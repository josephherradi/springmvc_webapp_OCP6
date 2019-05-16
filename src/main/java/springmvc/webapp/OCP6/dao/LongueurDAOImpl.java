package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Longueur;

@Repository
public class LongueurDAOImpl implements LongueurDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Longueur> getLongueurs() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Longueur> query = currentSession.createNamedQuery("FindLongueurs", 
				  Longueur.class);
		List<Longueur> ResultList = query.getResultList();
		
		return ResultList;
	}

	@Override
	public void saveLongueur(Longueur laLongueur) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(laLongueur);
		
	}

	@Override
	public Longueur getLongueur(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Longueur laLongueur=currentSession.get(Longueur.class,theId);
		return laLongueur;
	}

	@Override
	public void deleteLongueur(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Longueur longueur = currentSession.byId(Longueur.class).load(theId);
		currentSession.delete(longueur);		
	}

}
