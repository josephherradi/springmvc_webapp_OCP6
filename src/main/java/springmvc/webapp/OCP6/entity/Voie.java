package springmvc.webapp.OCP6.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity
@Table(name="voie")
@NamedQueries({
@NamedQuery(name = "FindVoies", query = "from Voie as v where v.spot.spotId= :theSpotId")

})




public class Voie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="voie_id")
	private int voieId;
	
	@Column(name="nbr_longueurs")
	private int nbrLongueurs;
	
	@Column(name="distance_spits")
	private double distanceSpits;
	
	@Column(name="remarques")
	private String remarques;
	
	@ManyToOne
	@JoinColumn(name="spot_id")
	private Spot spot;
	
	@OneToMany(targetEntity =Longueur.class ,mappedBy="voie",cascade=CascadeType.ALL)
	@ElementCollection(targetClass=Longueur.class)
	private List<Longueur> longueurs;
	
	public Voie() {}

	public int getVoieId() {
		return voieId;
	}

	public void setVoieId(int voieId) {
		this.voieId = voieId;
	}

	public int getNbrLongueurs() {
		return nbrLongueurs;
	}

	public void setNbrLongueurs(int nbrLongueurs) {
		this.nbrLongueurs = nbrLongueurs;
	}

	public double getDistanceSpits() {
		return distanceSpits;
	}

	public void setDistanceSpits(double distanceSpits) {
		this.distanceSpits = distanceSpits;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	@Override
	public String toString() {
		return "Voie [voieId=" + voieId + ", nbrLongueurs=" + nbrLongueurs + ", distanceSpits=" + distanceSpits
				+ ", remarques=" + remarques + "]";
	}
	
	
	

}
