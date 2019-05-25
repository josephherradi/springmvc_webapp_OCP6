package springmvc.webapp.OCP6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.webapp.OCP6.dao.VoieDAO;
import springmvc.webapp.OCP6.entity.Voie;


@Service
public class VoieServiceImpl implements VoieService {
	
	@Autowired
	private VoieDAO voieDAO;
	
	@Override
	@Transactional
	public List<Voie> getVoies(int spotId) {
		return voieDAO.getVoies(spotId);
	}

	@Override
	@Transactional
	public void saveVoie(Voie laVoie) {
		voieDAO.saveVoie(laVoie);
	}

	@Override
	@Transactional
	public Voie getVoie(int theId) {
		return voieDAO.getVoie(theId);
	}

	@Override
	@Transactional
	public void deleteVoie(int theId) {
		voieDAO.deleteVoie(theId);
	}


}
