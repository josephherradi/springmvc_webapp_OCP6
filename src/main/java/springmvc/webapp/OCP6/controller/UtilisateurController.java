package springmvc.webapp.OCP6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Utilisateur;
import springmvc.webapp.OCP6.service.UtilisateurService;

@Controller
@RequestMapping("/account")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String listSpots(@RequestParam("userId") String userId, @RequestParam("password") String password,
			HttpSession session, ModelMap theModelMap) {
		Utilisateur registredUserId=utilisateurService.getUtilisateur(userId);

		if (userId.equalsIgnoreCase(registredUserId.getUserId()) && password.equalsIgnoreCase(registredUserId.getPassword())) {
			session.setAttribute("user", userId);
			return "list-spots";
		} else {
			theModelMap.put("error", "Invalid Account");
			return "index";

		}
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:../account";
		
	}
	@RequestMapping(value = "registrationForm", method = RequestMethod.GET)
	public String registrationForm(Model theModel) {
		Utilisateur utilisateur = new Utilisateur();
		theModel.addAttribute("utilisateur", utilisateur);
		return "userRegistration-form";
	}
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		utilisateurService.saveUtilisateur(utilisateur);
		return "redirect:../account";
	}
}
