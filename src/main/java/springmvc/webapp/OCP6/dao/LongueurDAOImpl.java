package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Longueur;
import springmvc.webapp.OCP6.entity.Voie;
import springmvc.webapp.OCP6.service.VoieService;

@Repository
public class LongueurDAOImpl implements LongueurDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private VoieService voieService;

	@Override
	public List<Longueur> getLongueurs(int voieId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Longueur> query = currentSession.createNamedQuery("FindLongueurs", 
				  Longueur.class);
		query.setParameter("laVoieId", voieId);
		List<Longueur> ResultList = query.getResultList();
		
		return ResultList;
	}

	@Override
	public void saveLongueur(Longueur laLongueur,int voieId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Voie theVoie=voieService.getVoie(voieId);
		laLongueur.setVoie(theVoie);
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
