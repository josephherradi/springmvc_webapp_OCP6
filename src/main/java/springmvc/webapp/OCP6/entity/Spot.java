package springmvc.webapp.OCP6.entity;
import java.util.Date;
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
@Table(name="spot")
@NamedQueries({
@NamedQuery(name = "FindAllspots", query = "from Spot"),
})

public class Spot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="spot_id")
	private int spotId;
	
	@Column(name="spot_name")
	private String spotName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="lieu")
	private String lieu;
	
	@Column(name="nbr_secteurs")
	private int nbrSecteurs;
	
	@Column(name="nbr_voies")
	private int nbrVoies;
	
	@Column(name="voie_equipee")
	private Boolean voieEquipee;
	
	@Column(name="date_ajout")
	private Date dateAjout;
	
	@Column(name="tagged")
	private Boolean tagged;
	
	
	@ManyToOne
	@JoinColumn(name="utilisateur_pk")
	private Utilisateur utilisateur;

	
	@OneToMany(targetEntity=Voie.class, mappedBy="spot",cascade=CascadeType.ALL)
	@ElementCollection(targetClass=Voie.class)
	public List<Voie> voies;
		
	
	public Spot(){
		
	}

	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}

	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
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

	public Integer getNbrSecteurs() {
		return nbrSecteurs;
	}

	public void setNbrSecteurs(Integer nbrSecteurs) {
		this.nbrSecteurs = nbrSecteurs;
	}

	public Integer getNbrVoies() {
		return nbrVoies;
	}

	public void setNbrVoies(Integer nbrVoies) {
		this.nbrVoies = nbrVoies;
	}

	public Boolean getVoieEquipee() {
		return voieEquipee;
	}

	public void setVoieEquipee(Boolean voieEquipee) {
		this.voieEquipee = voieEquipee;
	}

	

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Boolean getTagged() {
		return tagged;
	}

	public void setTagged(Boolean tagged) {
		this.tagged = tagged;
	}

	@Override
	public String toString() {
		return "Spot [spotId=" + spotId + ", spotName=" + spotName + ", description=" + description + ", lieu=" + lieu
				+ ", nbrSecteurs=" + nbrSecteurs + ", nbrVoies=" + nbrVoies + ", voieEquipee=" + voieEquipee
				+ ", dateAjout=" + dateAjout + ", tagged=" + tagged + "]";
	}
}
