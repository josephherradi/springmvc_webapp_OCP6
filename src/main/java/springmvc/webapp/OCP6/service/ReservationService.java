package springmvc.webapp.OCP6.service;

import java.util.List;

import springmvc.webapp.OCP6.entity.Reservation;

public interface ReservationService {
	public List<Reservation> getUserReservations(String userId);
	public List<Reservation> getAskedReservation(String userId);
	public void saveOrUpdateResa(Reservation laReservation,int topoId);
	public void delete(int resaId);
	
}
