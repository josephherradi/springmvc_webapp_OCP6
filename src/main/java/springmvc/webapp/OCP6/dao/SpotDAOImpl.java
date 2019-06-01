package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.entity.Utilisateur;
import springmvc.webapp.OCP6.service.SpotService;
import springmvc.webapp.OCP6.service.UtilisateurService;

@Repository
public class SpotDAOImpl implements SpotDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
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

	@Override
	public List<Spot> searchSpots(String lieu, Integer  nbrSecteurs, Boolean tagged, Boolean voieEquipee) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryDyn="select s from Spot s where 1=1";
		
		if(!StringUtils.isEmpty(lieu)) {
			queryDyn=queryDyn + " and s.lieu= :lieu";
		}
		if(!StringUtils.isEmpty(nbrSecteurs)) {
			queryDyn=queryDyn + " and s.nbrSecteurs= :nbrSecteurs";
		}
		if(!StringUtils.isEmpty(tagged)) {
			queryDyn=queryDyn + " and s.tagged= :tagged";
		}
		if(!StringUtils.isEmpty(voieEquipee)) {
			queryDyn=queryDyn + " and s.voieEquipee= :voieEquipee";
		}
		
		
		Query<Spot> query = currentSession.createQuery(queryDyn,Spot.class);
		
		if(!StringUtils.isEmpty(lieu)) {
		query.setParameter("lieu", lieu);
		}
		if(!StringUtils.isEmpty(nbrSecteurs)) {
			query.setParameter("nbrSecteurs", nbrSecteurs);
		}
		if(!StringUtils.isEmpty(tagged)) {
			query.setParameter("tagged", tagged);
		}
		if(!StringUtils.isEmpty(voieEquipee)) {
			query.setParameter("voieEquipee", voieEquipee);
		}
		List<Spot> SearchResultList = query.getResultList();

		return SearchResultList;
	}

	}

