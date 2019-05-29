package springmvc.webapp.OCP6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.webapp.OCP6.dao.LongueurDAO;
import springmvc.webapp.OCP6.entity.Longueur;


@Service
public class LongueurServiceImpl implements LongueurService{
	@Autowired
	private LongueurDAO longueurDAO;
	
	@Override
	@Transactional
	public List<Longueur> getLongueurs(int voieId) {
		return longueurDAO.getLongueurs(voieId);
	}

	@Override
	@Transactional
	public void saveLongueur(Longueur laLongueur,int voieId) {
		longueurDAO.saveLongueur(laLongueur,voieId);
	}

	@Override
	@Transactional
	public Longueur getLongueur(int theId) {
		return longueurDAO.getLongueur(theId);
	}

	@Override
	@Transactional
	public void deleteLongueur(int theId) {
		longueurDAO.deleteLongueur(theId);
	}

}
