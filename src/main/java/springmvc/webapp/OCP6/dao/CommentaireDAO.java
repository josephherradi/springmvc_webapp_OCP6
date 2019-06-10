package springmvc.webapp.OCP6.dao;

import java.util.List;

import springmvc.webapp.OCP6.entity.Commentaire;

public interface CommentaireDAO {
	public List<Commentaire> getComments(int spotId);
	public void saveComment(Commentaire theComment,int spotId);
	public Commentaire getComment(int commentId);
	public void deleteComment(int commentId);

}
