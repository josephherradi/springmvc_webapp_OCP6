package springmvc.webapp.OCP6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.entity.Utilisateur;
import springmvc.webapp.OCP6.service.SpotService;

@Controller
@RequestMapping("/spots")
public class SpotController {

	@Autowired
	private SpotService spotService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listSpots(Model theModel) {
		List<Spot> thespots = spotService.getSpots();
		theModel.addAttribute("spots", thespots);
		return "list-spots";
	}

	@RequestMapping(value = "searchSpots", method = RequestMethod.GET)
	public String listSearchedSpots(@RequestParam(value = "lieu", required = false) String lieu,
			@RequestParam(value = "nbrSecteurs", required = false) Integer nbrSecteurs,
			@RequestParam(value = "tagged", required = false) Boolean tagged,
			@RequestParam(value = "voieEquipee", required = false) Boolean voieEquipee, Model theModel) {

		List<Spot> spotsFound = spotService.searchSpots(lieu, nbrSecteurs, tagged,voieEquipee);
		theModel.addAttribute("spotsFound", spotsFound);

		return "list-spots";
	}

	@RequestMapping(value = "showForm", method = RequestMethod.GET)
	public String showFormForAdd(Model theModel) {
		Spot theSpot = new Spot();
		theSpot.setTagged(false);
		theModel.addAttribute("spot", theSpot);
		return "spot-form";
	}

	@RequestMapping(value = "saveForm", method = RequestMethod.POST)
	public String saveSpot(@ModelAttribute("spot") Spot theSpot,HttpSession session, HttpServletRequest request) {
	    Utilisateur loggedUser=(Utilisateur)request.getSession().getAttribute("theUser");
		theSpot.setUtilisateur(loggedUser);
		spotService.saveSpot(theSpot);
		return "redirect:/spots/list";
		}

	

	@RequestMapping(value = "updateForm", method = RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("spotId") int theId, Model theModel) {
		Spot theSpot = spotService.getSpot(theId);
		theModel.addAttribute("spot", theSpot);
		return "spot-form";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteSpot(@RequestParam("spotId") int theId) {
	   spotService.deleteSpot(theId);
		
		return "redirect:/spots/list";
	}
	
	@RequestMapping(value = "mylist", method = RequestMethod.GET)
	public String userlistSpots(Model theModel,HttpServletRequest request) {
		List<Spot> theuserSpots = spotService.userSpots(request);
		theModel.addAttribute("theuserSpots", theuserSpots);
		return "user-spots";
	}

}
