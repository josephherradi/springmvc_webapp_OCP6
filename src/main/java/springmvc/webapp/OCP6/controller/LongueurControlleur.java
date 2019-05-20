package springmvc.webapp.OCP6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Longueur;
import springmvc.webapp.OCP6.service.LongueurService;


@Controller
public class LongueurControlleur {
	@Autowired
	private LongueurService longueurService;

	@GetMapping("/listLongueurs")
	public String listLongueurs(Model theModel) {
		List<Longueur> lesLongueurs= longueurService.getLongueurs();
		theModel.addAttribute("longueurs", lesLongueurs);
		return "list-spots";
	}
	
	@GetMapping("/showFormLongueur")
	public String showFormForAdd(Model theModel) {
		Longueur laLongueur=new Longueur();
		theModel.addAttribute("longueur", laLongueur);
		return "spot-form";
	}
	
	@PostMapping("/saveLongeur")
	public String saveVoie(@ModelAttribute("longueur") Longueur laLongueur) {
		longueurService.saveLongueur(laLongueur);
		return "redirect:/spot/list";
	}
	
	@GetMapping("/updateFormLongueur")
	public String showFormForUpdate(@RequestParam("longueurId") int theId,
									Model theModel) {
		Longueur laLongueur=longueurService.getLongueur(theId);	
		theModel.addAttribute("longueur", laLongueur);
		return "spot-form";
	}
	
	@GetMapping("/deleteLongueur")
	public String deleteLongueur(@RequestParam("longueurId") int theId) {
		longueurService.deleteLongueur(theId);
		return "redirect:/spot/list";
	}
	

}
