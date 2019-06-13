package springmvc.webapp.OCP6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.webapp.OCP6.dao.ReservationDAO;
import springmvc.webapp.OCP6.entity.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationDAO reservationDAO;

	@Override
	@Transactional
	public List<Reservation> getUserReservations(String userId) {
		return reservationDAO.getUserReservations(userId);
	}

	@Override
	@Transactional
	public List<Reservation> getAskedReservation(String userId) {
		return reservationDAO.getAskedReservation(userId);
	}

	@Override
	@Transactional
	public void saveOrUpdateResa(Reservation laReservation, int topoId) {
		reservationDAO.saveOrUpdateResa(laReservation,topoId);
		
	}

	@Override
	@Transactional
	public void delete(int resaId) {
		reservationDAO.delete(resaId);
	}
	
	@Override
	@Transactional
	public Reservation getReservation(int resaId) {
		return reservationDAO.getReservation(resaId);
	}

}
