package springmvc.webapp.OCP6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.entity.Voie;
import springmvc.webapp.OCP6.service.SpotService;
import springmvc.webapp.OCP6.service.VoieService;

@Controller
@RequestMapping("/spots")

public class VoieController {
	

	@Autowired
	private VoieService voieService;
	
	
	


	@RequestMapping(value="{spotId}/voies/list",method= RequestMethod.GET)
	public String listVoies(@RequestParam(value="spotId",required=true,defaultValue="2") int spotId,Model theModel) {
		List<Voie> lesVoies= voieService.getVoies(spotId);
		theModel.addAttribute("voies", lesVoies);
		return "list-voies";
	}
	
	@RequestMapping(value="{spotId}/voies/showForm",method= RequestMethod.GET)
	public String showFormForAdd(@RequestParam(value="spotId",required=true,defaultValue="2") int spotId,Model theModel) {
		Voie laVoie=new Voie();
		theModel.addAttribute("voie", laVoie);
		return "voie-form";
	}
	
	@RequestMapping(value="{spotId}/voies/save",method= RequestMethod.POST)
	public String saveVoie(@RequestParam(value="spotId",required=true,defaultValue="2") int spotId,@ModelAttribute("voie") Voie laVoie) {
		voieService.saveVoie(laVoie,spotId);
		return "redirect:list";
	}
	

	
	@RequestMapping(value="{spotId}/voies/updateForm",method= RequestMethod.GET)
	public String showFormForUpdate(@RequestParam(value="spotId",required=true,defaultValue="2") int spotId,@RequestParam("voieId") int voieId,
									Model theModel) {
		Voie laVoie=voieService.getVoie(voieId);	
		theModel.addAttribute("voie", laVoie);
		return "voie-form";
	}
	
	@RequestMapping(value="{spotId}/voies/delete",method= RequestMethod.GET)
	public String deleteSpot(@RequestParam(value="spotId",required=true,defaultValue="2") int spotId,@RequestParam("voieId") int voieId) {
		voieService.deleteVoie(voieId);;
		return "redirect:list";
	}


	

}
