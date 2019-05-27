package springmvc.webapp.OCP6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Voie;
import springmvc.webapp.OCP6.service.VoieService;

@Controller
@RequestMapping("/spots")

public class VoieController {
	

	@Autowired
	private VoieService voieService;
	
	
	


	@RequestMapping(value="{spotId}/voies/list",method= RequestMethod.GET)
	public String listVoies(@PathVariable("spotId") int spotId,Model theModel) {
		List<Voie> lesVoies= voieService.getVoies(spotId);
		theModel.addAttribute("voies", lesVoies);
		return "list-voies";
	}
	
	@RequestMapping(value="{spotId}/voies/showForm",method= RequestMethod.GET)
	public String showFormForAdd(@PathVariable("spotId") int spotId,Model theModel) {
		Voie laVoie=new Voie();
		theModel.addAttribute("voie", laVoie);
		return "voie-form";
	}
	
	@RequestMapping(value="{spotId}/voies/saveOrUpdate",method= RequestMethod.POST)
	public String saveVoie(@PathVariable("spotId") int spotId,@ModelAttribute("voie") Voie laVoie) {
		voieService.saveOrUpdateVoie(laVoie,spotId);
		return "redirect:list";
	}
	

	
	@RequestMapping(value="{spotId}/voies/updateForm",method= RequestMethod.GET)
	public String showFormForUpdate(@PathVariable("spotId") int spotId,@RequestParam("voieId") int voieId,
									Model theModel) {
		Voie laVoie=voieService.getVoie(voieId);	
		theModel.addAttribute("voie", laVoie);
		return "voie-form";
	}
	
	@RequestMapping(value="{spotId}/voies/delete",method= RequestMethod.GET)
	public String deleteSpot(@PathVariable("spotId") int spotId,@RequestParam("voieId") int voieId) {
		voieService.deleteVoie(voieId);;
		return "redirect:list";
	}


	

}
