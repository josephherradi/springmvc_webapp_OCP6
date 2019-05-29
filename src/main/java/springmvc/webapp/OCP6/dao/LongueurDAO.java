package springmvc.webapp.OCP6.dao;

import java.util.List;

import springmvc.webapp.OCP6.entity.Longueur;

public interface LongueurDAO {
	public List<Longueur> getLongueurs(int voieId);
	public void saveLongueur(Longueur laLongueur,int voieId);
	public Longueur getLongueur(int theId);
	public void deleteLongueur(int theId);
}
