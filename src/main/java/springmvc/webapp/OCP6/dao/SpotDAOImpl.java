package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Spot;

@Repository
public class SpotDAOImpl implements SpotDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Spot> getSpots(){
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Spot> query = currentSession.createNamedQuery("FindAllspots", 
				  Spot.class);
		List<Spot> ResultList = query.getResultList();
		
		return ResultList;
	}

	@Override
	public void saveSpot(Spot theSpot) {
	Session currentSession = sessionFactory.getCurrentSession();
	currentSession.saveOrUpdate(theSpot);


	}

	@Override
	public Spot getSpot(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Spot theSpot=currentSession.get(Spot.class,theId);
		return theSpot;
	}

	@Override
	public void deleteSpot(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Spot spotLine = currentSession.byId(Spot.class).load(theId);
		currentSession.delete(spotLine);
	}
}
