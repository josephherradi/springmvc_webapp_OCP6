package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Topo;
import springmvc.webapp.OCP6.entity.Utilisateur;
import springmvc.webapp.OCP6.service.UtilisateurService;

@Repository
public class TopoDAOImpl implements TopoDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	
	@Override
	public List<Topo> getUserTopos(String userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Topo> query = currentSession.createNamedQuery("FindUserTopos", 
				  Topo.class);
		query.setParameter("theUserId", userId);
		List<Topo> ResultList = query.getResultList();
		return ResultList;
	}

	@Override
	public void saveOrUpdateTopo(Topo leTopo, String userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Utilisateur theUser=utilisateurService.getUtilisateur(userId);
		leTopo.setUtilisateur(theUser);
		currentSession.saveOrUpdate(leTopo);
	}

	@Override
	public Topo getTopo(int topoId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Topo leTopo=currentSession.get(Topo.class, topoId);
		return leTopo;
	}

	@Override
	public void deleteTopo(int topoId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Topo leTopo=currentSession.byId(Topo.class).load(topoId);
		currentSession.delete(leTopo);	
	}
	
	@Override
	public List<Topo> getTopos(String userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Topo> query = currentSession.createNamedQuery("FindTopos", 
				  Topo.class);
		query.setParameter("theUserId", userId);
		List<Topo> ResultList = query.getResultList();
		return ResultList;

}
}
