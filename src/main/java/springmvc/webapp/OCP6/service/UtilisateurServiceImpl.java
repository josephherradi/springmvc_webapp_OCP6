package springmvc.webapp.OCP6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.webapp.OCP6.dao.UtilisateurDAO;
import springmvc.webapp.OCP6.entity.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	@Autowired
	private UtilisateurDAO utilisateurDao;

	@Override
	@Transactional
	public void saveUtilisateur(Utilisateur utilisateur) {
			utilisateurDao.saveUtilisateur(utilisateur);
	}

	@Override
	@Transactional
	public Utilisateur getUtilisateur(String userId) {
		return utilisateurDao.getUtilisateur(userId);
	}

}
