package springmvc.webapp.OCP6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="utilisateur")


public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="utilisateur_pk")
	private int utilisateurpk;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="password")
	private String password;
	
	
	public Utilisateur() {}

	public int getUtilisateurpk() {
		return utilisateurpk;
	}

	public void setUtilisateurpk(int utilisateurpk) {
		this.utilisateurpk = utilisateurpk;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utilisateur [utilisateurpk=" + utilisateurpk + ", nom=" + nom + ", prenom=" + prenom + ", userId="
				+ userId + ", userType=" + userType + ", password=" + password + "]";
	}


	
	
	
	

}
