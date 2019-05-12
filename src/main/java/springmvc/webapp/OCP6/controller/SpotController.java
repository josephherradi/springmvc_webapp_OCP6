package springmvc.webapp.OCP6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.service.SpotService;



@Controller
@RequestMapping("/spot")
public class SpotController {
	
	@Autowired
	private SpotService spotService;

	@GetMapping("/list")
	public String listSpots(Model theModel) {
	List<Spot> theSpots = spotService.getSpots();
	theModel.addAttribute("spots", theSpots);
	return "list-spots";
		
	}
	
	
}
