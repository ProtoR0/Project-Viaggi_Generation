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
	
	@GetMapping
	public String getPage(HttpSession session, Model model,@RequestParam(name = "id", required = false) Integer id) {
	
		if(session.getAttribute("admin") != null) {
			if(recensioneService.findByPubblicato(0) != null) {
				model.addAttribute("admin", session.getAttribute("admin"));
				List<Recensione> recensioni = recensioneService.findByPubblicato(0);
				
				for (Recensione recensione : recensioni) {
					recensione.setDurata();
				}
				
				model.addAttribute("recensioni", recensioni);
				if(id != null) {
					model.addAttribute("recensione", recensioneService.findRecensioneInListById(recensioni, id) != null ? recensioneService.findRecensioneInListById(recensioni, id) : recensioneService.findById(id));	
				}else {
					model.addAttribute("recensione", new Recensione());
				}

				
				if(id == null) {
				session.removeAttribute("id_recensione");
				}
				session.setAttribute("id_recensione", id != null ? id : null);
				return "area_admin_2";	
			}
			
			return "redirect:/area_admin";
		}

		return "redirect:/login";
	}
	
	@GetMapping("/cambioStato")
	public String cambioStato(@RequestParam("pubblicare") String pubblicare, HttpSession session) {
		if(session.getAttribute("id_recensione") != null) {
			Recensione recensione= recensioneService.findById(session.getAttribute("id_recensione") != null ? (int) session.getAttribute("id_recensione") : null);
			recensione.setPubblicato(pubblicare.equals("Pubblicare") ? 1 : 2);
			session.removeAttribute("id_recensione");
			recensioneService.saveRecensione(recensione);
			
			return recensioneService.findByPubblicato(0) != null ? "redirect:/area_admin2" : "redirect:/area_admin";
		}

		return "redirect:/area_admin2";
		
	}
}
