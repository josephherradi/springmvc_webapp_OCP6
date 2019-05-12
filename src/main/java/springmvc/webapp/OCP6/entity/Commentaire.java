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



@Entity
@Table(name="commentaire")

public class Commentaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	
	
	@Column(name="date")
	private Date date;
	
	@Column(name="contenu")
	private String contenu;
	
	
	@ManyToOne
	@JoinColumn(name="spot_id")
	Spot spot;
	
	@ManyToOne
	@JoinColumn(name="utilisateurpk")
	Utilisateur utilisateur;
	
	
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



	@Override
	public String toString() {
		return "Commentaire [commentId=" + commentId + ", date=" + date + ", contenu=" + contenu
				+ "]";
	}
	
	
	
	
	

}
