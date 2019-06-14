package springmvc.webapp.OCP6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Reservation;
import springmvc.webapp.OCP6.entity.Topo;
import springmvc.webapp.OCP6.entity.Utilisateur;
import springmvc.webapp.OCP6.service.ReservationService;
import springmvc.webapp.OCP6.service.TopoService;

@Controller
@RequestMapping("/topos")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private TopoService topoService;

	@RequestMapping(value = "reservations/userlist", method = RequestMethod.GET)
	public String userListResa(Model theModel, HttpServletRequest request) {
		Utilisateur loggedUser = (Utilisateur) request.getSession().getAttribute("theUser");
		List<Reservation> userResaList = reservationService.getUserReservations(loggedUser.getUserId());
		theModel.addAttribute("userResa", userResaList);
		return "resa-userlist";
	}

	@RequestMapping(value = "reservations/requestlist", method = RequestMethod.GET)
	public String listResa(Model theModel, HttpServletRequest request) {
		Utilisateur loggedUser = (Utilisateur) request.getSession().getAttribute("theUser");
		List<Reservation> requestResaList = reservationService.getAskedReservation(loggedUser.getUserId());
		theModel.addAttribute("requestResa", requestResaList);
		return "resa-requestlist";
	}

	@RequestMapping(value = "{topoId}/reservations/showResaForm", method = RequestMethod.GET)
	public String showFormForAdd(@PathVariable("topoId") int topoId, Model theModel, HttpServletRequest request) {
		Reservation laReservation = new Reservation();

		laReservation.setStatut("en attente");
		Topo leTopo = topoService.getTopo(topoId);
		laReservation.setTopo(leTopo);
		theModel.addAttribute("laReservation", laReservation);
		theModel.addAttribute("leTopo", leTopo);

		return "reservation-form";
	}

	@RequestMapping(value = "{topoId}/reservations/saveOrUpdate", method = RequestMethod.POST)
	public String saveResa(@PathVariable("topoId") int topoId,
			@ModelAttribute("laReservation") Reservation laReservation,BindingResult result, HttpSession session,
			HttpServletRequest request) {
		Utilisateur testUser=laReservation.getUtilisateur();
		if(testUser==null) {
		Utilisateur loggedUser = (Utilisateur) request.getSession().getAttribute("theUser");
		laReservation.setUtilisateur(loggedUser);}
		reservationService.saveOrUpdateResa(laReservation, topoId);
		return "redirect:/spots/list";
	}

	@RequestMapping(value = "{topoId}/reservations/updateForm", method = RequestMethod.GET)
	public String updateForm(@PathVariable("topoId") int topoId, @RequestParam("resaId") int resaId, Model theModel) {
		Reservation laReservation=reservationService.getReservation(resaId);
		theModel.addAttribute("laReservation",laReservation);
		return "reservation-form";
	};

	@RequestMapping(value = "{topoId}/reservations/delete", method = RequestMethod.GET)
	public String deleteSpot(@PathVariable("topoId") int topoId, @RequestParam("resaId") int resaId) {
		reservationService.delete(resaId);
		return "redirect:/topos/reservations/userlist";

	}

}