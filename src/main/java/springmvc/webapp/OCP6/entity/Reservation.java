package springmvc.webapp.OCP6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reservation_id")
	private int reservationId;
	
	@Column(name="statut")
	private String statut;
	
	
	@ManyToOne
	@JoinColumn(name="topo_id")
	private Topo topo;
	
	@ManyToOne
	@JoinColumn(name="utilisateur_pk")
	private Utilisateur utilisateur;
	
	
	public Reservation(){
		
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", statut=" + statut + "]";
	}
	
	
	

}
