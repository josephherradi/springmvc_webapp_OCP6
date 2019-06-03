package springmvc.webapp.OCP6.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import springmvc.webapp.OCP6.entity.Spot;

public interface SpotService {
	public List<Spot> getSpots();
	public void saveSpot(Spot theSpot);
	public Spot getSpot(int theId);
	public void deleteSpot(int theId);
	public List<Spot> searchSpots(String  lieu, Integer  nbrSecteurs, Boolean tagged, Boolean voieEquipee);
	public List<Spot> userSpots(HttpServletRequest request);

	

}
