package springmvc.webapp.OCP6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.webapp.OCP6.dao.CommentaireDAO;
import springmvc.webapp.OCP6.entity.Commentaire;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	@Autowired
	private CommentaireDAO commentaireDAO;

	@Override
	@Transactional
	public List<Commentaire> getComments(int spotId) {
		return commentaireDAO.getComments(spotId);
	}

	@Override
	@Transactional
	public void saveComment(Commentaire theComment,int spotId) {
		commentaireDAO.saveComment(theComment,spotId);
	}

	@Override
	@Transactional
	public Commentaire getComment(int commentId) {
		return commentaireDAO.getComment(commentId);
	}

	@Override
	@Transactional
	public void deleteComment(int commentId) {
		commentaireDAO.deleteComment(commentId);
	}

}
