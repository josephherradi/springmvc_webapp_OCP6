package springmvc.webapp.OCP6.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="topo")
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
	
	@Column(name="date_parution")
	private Date date;
	
	@Column(name="statut")
	private String statut;
	
	@Column(name="owner_id")
	private String ownerId;
	
	@ManyToOne
	@JoinColumn(name="utilisateurpk")
	Utilisateur utilisateur;
	
	@OneToMany
	Reservation reservation;
	
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

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "Topo [topoId=" + topoId + ", nom=" + nom + ", description=" + description + ", lieu=" + lieu + ", date="
				+ date + ", statut=" + statut + ", ownerId=" + ownerId + "]";
	}
	
	
	
	

}
