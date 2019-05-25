package springmvc.webapp.OCP6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springmvc.webapp.OCP6.entity.Longueur;
import springmvc.webapp.OCP6.service.LongueurService;


@RestController
@RequestMapping("/longueurs")
public class LongueurControlleur {
	@Autowired
	private LongueurService longueurService;

	@RequestMapping(value="list", method = RequestMethod.GET)
	public String listLongueurs(Model theModel) {
		List<Longueur> lesLongueurs= longueurService.getLongueurs();
		theModel.addAttribute("longueurs", lesLongueurs);
		return "list-longueurs";
	}
	
	@RequestMapping(value="showForm",method = RequestMethod.GET)
	public String showFormForAdd(Model theModel) {
		Longueur laLongueur=new Longueur();
		theModel.addAttribute("longueur", laLongueur);
		return "longueur-form";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String saveVoie(@ModelAttribute("longueur") Longueur laLongueur) {
		longueurService.saveLongueur(laLongueur);
		return "redirect:/longueurs/list";
	}
	
	
	@RequestMapping(value="updateForm/{theId}",method=RequestMethod.PUT)
	public String showFormForUpdate(@RequestParam("longueurId") int theId,
									Model theModel) {
		Longueur laLongueur=longueurService.getLongueur(theId);	
		theModel.addAttribute("longueur", laLongueur);
		return "longueur-form";
	}
	
	@RequestMapping(value="delete/{theId}",method=RequestMethod.DELETE)
	public String deleteLongueur(@RequestParam("longueurId") int theId) {
		longueurService.deleteLongueur(theId);
		return "redirect:/longueurs/list";
	}
	

}
