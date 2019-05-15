package springmvc.webapp.OCP6.service;

import java.util.List;

import springmvc.webapp.OCP6.entity.Longueur;


public interface LongueurService {
	public List<Longueur> getLongueurs();
	public void saveLongueur(Longueur laLongueur);
	public Longueur getLongueur(int theId);
	public void deleteLongueur(int theId);
}
