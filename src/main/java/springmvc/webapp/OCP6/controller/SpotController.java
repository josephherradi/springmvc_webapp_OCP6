package springmvc.webapp.OCP6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.service.SpotService;



@Controller
@RequestMapping("/spot")
public class SpotController {

	@Autowired
	private SpotService spotService;

	@GetMapping("/list")
	public String listSpots(Model theModel) {
		List<Spot> thespots= spotService.getSpots();
		theModel.addAttribute("spots", thespots);
		return "list-spots";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Spot theSpot=new Spot();
		theModel.addAttribute("spot", theSpot);
		return "spot-form";
	}
	
	@PostMapping("/saveSpot")
	public String saveSpot(@ModelAttribute("spot") Spot theSpot) {
		spotService.saveSpot(theSpot);
		return "redirect:/spot/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("spotId") int theId,
									Model theModel) {
		Spot theSpot=spotService.getSpot(theId);	
		theModel.addAttribute("spot", theSpot);
		return "spot-form";
	}
	
	@GetMapping("/delete")
	public String deleteSpot(@RequestParam("spotId") int theId) {
		spotService.deleteSpot(theId);
		return "redirect:/spot/list";
	}
	
	
	
	
	
	
	


}
