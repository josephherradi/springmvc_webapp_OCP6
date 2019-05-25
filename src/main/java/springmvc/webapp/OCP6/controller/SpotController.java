package springmvc.webapp.OCP6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.service.SpotService;



@Controller
@RequestMapping("/spots")
public class SpotController {

	@Autowired
	private SpotService spotService;


	@RequestMapping(value="list", method= RequestMethod.GET)
	public String listSpots(Model theModel) {
		List<Spot> thespots= spotService.getSpots();
		theModel.addAttribute("spots", thespots);
		return "list-spots";
	}
	
	
	
	@RequestMapping(value="showForm",method = RequestMethod.GET)
	public String showFormForAdd(Model theModel) {
		Spot theSpot=new Spot();
		theModel.addAttribute("spot", theSpot);
		return "spot-form";
	}

	
	@RequestMapping(value="saveForm",method=RequestMethod.POST)
	public String saveSpot(@ModelAttribute("spot") Spot theSpot) {
		spotService.saveSpot(theSpot);
		return "redirect:/spots/list";
	}
	
	
	@RequestMapping(value="updateForm",method=RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("spotId") int theId,
									Model theModel) {
		Spot theSpot=spotService.getSpot(theId);	
		theModel.addAttribute("spot", theSpot);
		return "spot-form";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public  String deleteSpot(@RequestParam("spotId") int theId)  {
		spotService.deleteSpot(theId);
		return "redirect:/spots/list";
	}
	
	
	
	
	
	
	


}
