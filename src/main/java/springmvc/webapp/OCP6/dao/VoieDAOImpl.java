package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.controller.VoieController;
import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.entity.Voie;
import springmvc.webapp.OCP6.service.SpotService;

@Repository
public class VoieDAOImpl implements VoieDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private SpotService spotService;

	@Override
	public List<Voie> getVoies(int spotId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Voie> query = currentSession.createNamedQuery("FindVoies", Voie.class);
		query.setParameter("theSpotId", spotId);
		List<Voie> ResultList = query.getResultList();

		return ResultList;
	}

	@Override
	public void saveOrUpdateVoie(Voie laVoie, int spotId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Spot theSpot=spotService.getSpot(spotId);	
		laVoie.setSpot(theSpot);
		currentSession.saveOrUpdate(laVoie);	
	}

	@Override
	public Voie getVoie(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Voie laVoie = currentSession.get(Voie.class, theId);
		return laVoie;
	}

	@Override
	public void deleteVoie(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Voie voie = currentSession.byId(Voie.class).load(theId);
		currentSession.delete(voie);

	}

}
