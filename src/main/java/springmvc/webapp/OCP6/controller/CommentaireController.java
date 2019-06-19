package springmvc.webapp.OCP6.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Commentaire;
import springmvc.webapp.OCP6.entity.Utilisateur;
import springmvc.webapp.OCP6.service.CommentaireService;

@Controller
@RequestMapping("/spots")
public class CommentaireController {
	@Autowired CommentaireService commentaireService;
	

	
	@RequestMapping(value="{spotId}/commentaires/list",method= RequestMethod.GET)
	public String listCommenaires(@PathVariable("spotId") int spotId,Model theModel) {
		List<Commentaire> theComments= commentaireService.getComments(spotId);
		theModel.addAttribute("theComments", theComments);
		return "list-commentaires";
	}
	
	@RequestMapping(value="{spotId}/commentaires/showForm",method= RequestMethod.GET)
	public String showFormForAdd(@PathVariable("spotId") int spotId,Model theModel) {
		Commentaire theComment=new Commentaire();
		theModel.addAttribute("theComment", theComment);
		return "commentaire-form";
	}
	
	@RequestMapping(value="{spotId}/commentaires/saveForm",method= RequestMethod.POST)
	public String saveCommentaire(@PathVariable("spotId") int spotId,@ModelAttribute("theComment") Commentaire theComment,BindingResult result,HttpSession session,HttpServletRequest request) {
		Date date = new Date();
		theComment.setDate(date);
	    Utilisateur loggedUser=(Utilisateur)request.getSession().getAttribute("theUser");
		theComment.setUtilisateur(loggedUser);
		commentaireService.saveComment(theComment, spotId);
		return "redirect:list";
	}
	

	
	@RequestMapping(value="{spotId}/commentaires/updateForm",method= RequestMethod.GET)
	public String showFormForUpdate(@PathVariable("spotId") int spotId,@RequestParam("commentId") int commentId,
									Model theModel) {
		Commentaire theComment=commentaireService.getComment(commentId);
		theModel.addAttribute("theComment", theComment);
		return "commentaire-form";
	}
	
	@RequestMapping(value="{spotId}/commentaires/delete",method= RequestMethod.GET)
	public String deleteSpot(@PathVariable("spotId") int spotId,@RequestParam("commentId") int commentId) {
		commentaireService.deleteComment(commentId);
		return "redirect:list";
	}

	

}
