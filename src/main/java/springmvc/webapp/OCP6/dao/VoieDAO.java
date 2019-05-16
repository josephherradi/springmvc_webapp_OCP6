package springmvc.webapp.OCP6.dao;

import java.util.List;

import springmvc.webapp.OCP6.entity.Voie;

public interface VoieDAO {

	public List<Voie> getVoies();
	public void saveVoie(Voie laVoie);
	public Voie getVoie(int theId);
	public void deleteVoie(int theId);

}
