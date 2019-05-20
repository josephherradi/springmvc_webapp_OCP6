package springmvc.webapp.OCP6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Voie;
import springmvc.webapp.OCP6.service.VoieService;

@Controller
public class VoieController {
	

	@Autowired
	private VoieService voieService;

	@GetMapping("/listVoies")
	public String listVoies(Model theModel) {
		List<Voie> lesVoies= voieService.getVoies();
		theModel.addAttribute("voies", lesVoies);
		return "list-spots";
	}
	
	@GetMapping("/showFormVoie")
	public String showFormForAdd(Model theModel) {
		Voie laVoie=new Voie();
		theModel.addAttribute("voie", laVoie);
		return "spot-form";
	}
	
	@PostMapping("/saveVoie")
	public String saveVoie(@ModelAttribute("voie") Voie laVoie) {
		voieService.saveVoie(laVoie);;
		return "redirect:/spot/list";
	}
	
	@GetMapping("/updateFormVoie")
	public String showFormForUpdate(@RequestParam("voieId") int theId,
									Model theModel) {
		Voie laVoie=voieService.getVoie(theId);	
		theModel.addAttribute("voie", laVoie);
		return "spot-form";
	}
	
	@GetMapping("/deleteVoie")
	public String deleteSpot(@RequestParam("voieId") int theId) {
		voieService.deleteVoie(theId);;
		return "redirect:/spot/list";
	}
	

}
