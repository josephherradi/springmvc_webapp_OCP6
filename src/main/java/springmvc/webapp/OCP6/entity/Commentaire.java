package springmvc.webapp.OCP6.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="commentaire")

public class Commentaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="contenu")
	private String contenu;
	
	public Commentaire() {}
	
	

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}




	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return "Commentaire [commentId=" + commentId + ", userId=" + userId + ", date=" + date + ", contenu=" + contenu
				+ "]";
	}
	
	
	
	
	

}
