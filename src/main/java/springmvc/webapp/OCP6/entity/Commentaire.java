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



@Entity
@Table(name="commentaire")
@NamedQueries({
@NamedQuery(name = "FindComments", query = "from Commentaire as c where c.spot.spotId= :theSpotId")

})


public class Commentaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	
	
	@Column(name="date",updatable=false)
	private Date date;
	
	@Column(name="contenu")
	private String contenu;
	
	
	@ManyToOne
	@JoinColumn(name="spot_id")
	private Spot spot;
	
	@ManyToOne
	@JoinColumn(name="utilisateur_pk")
	private Utilisateur utilisateur;
	
	
	public Commentaire() {}
	
	

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}




	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}



	public Spot getSpot() {
		return spot;
	}



	public void setSpot(Spot spot) {
		this.spot = spot;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	@Override
	public String toString() {
		return "Commentaire [commentId=" + commentId + ", date=" + date + ", contenu=" + contenu + ", spot=" + spot
				+ ", utilisateur=" + utilisateur + "]";
	}




	
	
	
	
	

}
