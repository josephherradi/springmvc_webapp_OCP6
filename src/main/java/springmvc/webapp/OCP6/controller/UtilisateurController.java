package springmvc.webapp.OCP6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class UtilisateurController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String listSpots(@RequestParam("userId") String userId, @RequestParam("password") String password,
			HttpSession session, ModelMap theModelMap) {

		if (userId.equalsIgnoreCase("user") && password.equalsIgnoreCase("123")) {
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
}
