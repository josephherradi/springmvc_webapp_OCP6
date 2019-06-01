package springmvc.webapp.OCP6.dao;

import java.util.List;

import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.entity.Utilisateur;

public interface SpotDAO {
	public List<Spot> getSpots();
	public void saveSpot(Spot theSpot);
	public Spot getSpot(int theId);
	public void deleteSpot(int theId);
	public List<Spot> searchSpots(String lieu, Integer nbrSecteurs, Boolean  tagged, Boolean voieEquipee);

}
