package springmvc.webapp.OCP6.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Utilisateur;

@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUtilisateur(Utilisateur utilisateur) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(utilisateur);
	}

	@Override
	public Utilisateur getUtilisateur(String userId) {
		Session currentSession = sessionFactory.getCurrentSession();	
		String queryString="select u from Utilisateur u where u.userId=:userId";
		Query<Utilisateur> query = currentSession.createQuery(queryString,Utilisateur.class);
		query.setParameter("userId", userId);
		List<Utilisateur> ResultList = query.getResultList();

		return ResultList.get(0);
	}

}
