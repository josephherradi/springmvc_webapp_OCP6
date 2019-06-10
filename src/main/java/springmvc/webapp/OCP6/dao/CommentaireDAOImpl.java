package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Commentaire;
import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.service.SpotService;

@Repository
public class CommentaireDAOImpl implements CommentaireDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SpotService spotService; 

	@Override
	public List<Commentaire> getComments(int spotId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Commentaire> query=currentSession.createNamedQuery("FindComments",Commentaire.class);
		query.setParameter("theSpotId", spotId);
		List<Commentaire> ResultList=query.getResultList();
		return ResultList;
	}

	@Override
	public void saveComment(Commentaire theComment, int spotId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Spot theSpot= spotService.getSpot(spotId);
		theComment.setSpot(theSpot);
		currentSession.saveOrUpdate(theComment);
	}

	@Override
	public Commentaire getComment(int commentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Commentaire theComment=currentSession.get(Commentaire.class, commentId);
		return theComment;
	}

	@Override
	public void deleteComment(int commentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Commentaire comment=currentSession.byId(Commentaire.class).load(commentId);
		currentSession.delete(comment);
		
	}

}
