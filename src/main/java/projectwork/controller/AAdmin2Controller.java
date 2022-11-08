package projectwork.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectwork.model.Recensione;
import projectwork.service.RecensioneService;

@Controller
@RequestMapping("/area_admin2")
public class AAdmin2Controller {
	
	@Autowired
	private RecensioneService recensioneService;

	private Integer id;
	
	@GetMapping
	public String getPage(HttpSession session, Model model,@RequestParam(name = "id", required = false) Integer id) {
	
		if(session.getAttribute("admin") != null) {
			List<Recensione> recensioni = recensioneService.findByPubblicato(0);
			model.addAttribute("recensioni", recensioni);
			model.addAttribute("recensione", id != null ? recensioneService.findRecensioneInListById(recensioni, id) : new Recensione());

			return "area_admin_2";			
		}

		return "redirect:/login";
	}
	
	@GetMapping("/cambioStato")
	public String cambioStato(@RequestParam("pubblicare") String pubblicare) {
		Recensione recensione= recensioneService.findById(id);
		recensione.setPubblicato(pubblicare.equals("Pubblicare") ? 1 : 2);
		
		recensioneService.saveRecensione(recensione);
		
		return recensioneService.findByPubblicato(0) != null ? "redirect:/area_admin2" : "redirect:/area_admin";
		
	}
}
