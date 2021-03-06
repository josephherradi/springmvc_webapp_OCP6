package springmvc.webapp.OCP6.service;

import java.util.List;

import springmvc.webapp.OCP6.entity.Voie;

public interface VoieService {
	
	public List<Voie> getVoies(int spotId);
	public void saveOrUpdateVoie(Voie laVoie, int spotId);
	public Voie getVoie(int theId);
	public void deleteVoie(int theId);

}
