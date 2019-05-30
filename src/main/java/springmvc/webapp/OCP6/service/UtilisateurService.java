package springmvc.webapp.OCP6.service;

import springmvc.webapp.OCP6.entity.Utilisateur;

public interface UtilisateurService {
	public void saveUtilisateur(Utilisateur utilisateur);
	public Utilisateur getUtilisateur(String userId);

}
