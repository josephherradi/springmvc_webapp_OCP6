package springmvc.webapp.OCP6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="asker")
	private Utilisateur asker;
	
	@Column(name="owner")
	private Utilisateur owner;
	
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

	public Utilisateur getAsker() {
		return asker;
	}

	public void setAsker(Utilisateur asker) {
		this.asker = asker;
	}

	public Utilisateur getOwner() {
		return owner;
	}

	public void setOwner(Utilisateur owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", statut=" + statut + ", asker=" + asker + ", owner="
				+ owner + "]";
	}
	
	
	

}
