package springmvc.webapp.OCP6.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="topo")
@NamedQueries({
@NamedQuery(name = "FindUserTopos", query = "from Topo as t where t.utilisateur.userId= :theUserId"),
@NamedQuery(name = "FindTopos", query = "from Topo as t where t.utilisateur.userId!= :theUserId")


})
public class Topo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="topo_id")
	private int topoId;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="description")
	private String description;
	
	@Column(name="lieu")
	private String lieu;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_parution")
	private Date date;
	
	@Column(name="statut")
	private String statut;
	
	@ManyToOne
	@JoinColumn(name="utilisateur_pk")
	private Utilisateur utilisateur;
	
	
	public Topo() {}

	public int getTopoId() {
		return topoId;
	}

	public void setTopoId(int topoId) {
		this.topoId = topoId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Topo [topoId=" + topoId + ", nom=" + nom + ", description=" + description + ", lieu=" + lieu + ", date="
				+ date + ", statut=" + statut + "]";
	}
	
	
	
	

}
