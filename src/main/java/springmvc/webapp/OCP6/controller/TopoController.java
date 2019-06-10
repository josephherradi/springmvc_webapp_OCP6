package springmvc.webapp.OCP6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.webapp.OCP6.entity.Topo;
import springmvc.webapp.OCP6.service.TopoService;

@Controller
@RequestMapping("/mestopos")
public class TopoController {
	@Autowired
	private TopoService topoService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listTopos(Model theModel, HttpServletRequest request, HttpSession session) {
		String userId = (String) request.getSession().getAttribute("user");
		List<Topo> lesTopos = topoService.getTopos(userId);
		theModel.addAttribute("topos", lesTopos);
		return "list-topos";
	}

	@RequestMapping(value = "showForm", method = RequestMethod.GET)
	public String showFormForAdd(Model theModel) {
		Topo leTopo = new Topo();
		theModel.addAttribute("leTopo", leTopo);
		return "topo-form";
	}

	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public String saveVoie(@ModelAttribute("leTopo") Topo leTopo, HttpServletRequest request, HttpSession session) {
		String userId = (String) request.getSession().getAttribute("user");
		topoService.saveOrUpdateTopo(leTopo, userId);
		return "redirect:list";

	}

	@RequestMapping(value = "updateForm", method = RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("topoId") int topoId, Model theModel) {
		Topo leTopo = topoService.getTopo(topoId);
		theModel.addAttribute("leTopo", leTopo);
		return "topo-form";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteSpot(@RequestParam("topoId") int topoId) {
		topoService.deleteTopo(topoId);
		return "redirect:list";
	}
}
