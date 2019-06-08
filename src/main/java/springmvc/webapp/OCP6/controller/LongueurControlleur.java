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
import springmvc.webapp.OCP6.entity.Longueur;
import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.service.LongueurService;
import springmvc.webapp.OCP6.service.SpotService;


@Controller
@RequestMapping("/spots")
public class LongueurControlleur {
	@Autowired
	private LongueurService longueurService;
	
	@Autowired
	private SpotService spotService;

	@RequestMapping(value="{spotId}/voies/{voieId}/longueurs/list",method= RequestMethod.GET)
	public String listLongueurs(@PathVariable("spotId") int spotId,@PathVariable("voieId") int voieId,Model theModel) {
		List<Longueur> lesLongueurs= longueurService.getLongueurs(voieId);
		theModel.addAttribute("longueurs", lesLongueurs);
		Spot theSpot=spotService.getSpot(spotId);
		theModel.addAttribute("spot", theSpot);

		return "list-longueurs";
	}
	
	@RequestMapping(value="{spotId}/voies/{voieId}/longueurs/showForm",method = RequestMethod.GET)
	public String showFormForAdd(Model theModel) {
		Longueur laLongueur=new Longueur();
		theModel.addAttribute("longueur", laLongueur);
		return "longueur-form";
	}
	
	@RequestMapping(value="{spotId}/voies/{voieId}/longueurs/saveOrUpdate",method=RequestMethod.POST)
	public String saveLongueur(@PathVariable("spotId") int spotId,@PathVariable("voieId") int voieId,@ModelAttribute("longueur") Longueur laLongueur) {
		longueurService.saveLongueur(laLongueur,voieId);
		return "redirect:list";
	}
	
	
	@RequestMapping(value="{spotId}/voies/{voieId}/longueurs/updateForm",method=RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("longueurId") int theId,
									Model theModel) {
		Longueur laLongueur=longueurService.getLongueur(theId);	
		theModel.addAttribute("longueur", laLongueur);
		return "longueur-form";
	}
	
	@RequestMapping(value="{spotId}/voies/{voieId}/longueurs/delete",method=RequestMethod.GET)
	public String deleteLongueur(@RequestParam("longueurId") int theId) {
		longueurService.deleteLongueur(theId);
		return "redirect:list";
	}
	

}
