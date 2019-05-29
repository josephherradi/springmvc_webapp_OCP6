package springmvc.webapp.OCP6.entity;

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



@Entity
@Table(name="longueur")
@NamedQueries({
@NamedQuery(name = "FindLongueurs", query = "from Longueur as l where l.voie.voieId=:laVoieId"),
})

public class Longueur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="valeur")
	private double valeur;
	
	@Column(name="relai")
	private double relai;
	
	@Column(name="cotation")
	private String cotation;
	
	
	@ManyToOne
	@JoinColumn(name="voie_id")
	private Voie voie;
	
	
	public Longueur() {}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public double getRelai() {
		return relai;
	}

	public void setRelai(double relai) {
		this.relai = relai;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	@Override
	public String toString() {
		return "Longueur [Id=" + Id + ", valeur=" + valeur + ", relai=" + relai + ", cotation=" + cotation + "]";
	}
	
	
	

}
