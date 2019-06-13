package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Reservation;
import springmvc.webapp.OCP6.entity.Topo;
import springmvc.webapp.OCP6.service.TopoService;

@Repository
public class ReservationDAOImpl implements ReservationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private TopoService topoService;

	@Override
	public List<Reservation> getUserReservations(String userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Reservation> query=currentSession.createNamedQuery("FindUserReservation",Reservation.class);
		query.setParameter("theUserId", userId);
		List<Reservation> ResultList=query.getResultList();
		return ResultList;
	}

	@Override
	public List<Reservation> getAskedReservation(String userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Reservation> query=currentSession.createNamedQuery("FindAskedReservation",Reservation.class);
		query.setParameter("theOwnerId", userId);
		List<Reservation> ResultList2=query.getResultList();
		return ResultList2;
	}

	@Override
	public void saveOrUpdateResa(Reservation laReservation, int topoId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Topo leTopo=topoService.getTopo(topoId);
		leTopo.setStatut("indisponible");
		laReservation.setTopo(leTopo);
		currentSession.saveOrUpdate(laReservation);

	}

	@Override
	public void delete(int resaId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Reservation laReservation=currentSession.byId(Reservation.class).load(resaId);
		currentSession.delete(laReservation);
	}
	
	@Override
	public Reservation getReservation(int resaId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Reservation laReservation=currentSession.get(Reservation.class, resaId);
		
		return laReservation;
	}

}
