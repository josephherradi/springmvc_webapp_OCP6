package springmvc.webapp.OCP6.dao;

import springmvc.webapp.OCP6.entity.Utilisateur;

public interface UtilisateurDAO {
	public void saveUtilisateur(Utilisateur utilisateur);
	public Utilisateur getUtilisateur(String userId);

}
