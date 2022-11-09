package projectwork.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectwork.model.Account;
import projectwork.model.Recensione;
import projectwork.service.AccountService;
import projectwork.service.RecensioneService;

@Controller
@RequestMapping("/area_admin")
public class AAdminController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RecensioneService recensioneService;
	
	@GetMapping
	public String getPage(HttpSession session, Model model) {
		
		if(session.getAttribute("admin") != null) {
			model.addAttribute("admin", session.getAttribute("admin"));
	
			model.addAttribute("utenti", (List<Account>) accountService.findAll());
			model.addAttribute("recensioni1", (List<Recensione>) recensioneService.findByPubblicato(1));
			model.addAttribute("recensioni2", (List<Recensione>) recensioneService.findByPubblicato(2));
			
			model.addAttribute("RecensioniDaVerificare", recensioneService.findByPubblicato(0) != null ? true : null);
			
			return "area_admin";
		}
		
		return "redirect:/home";
	}
	
	@GetMapping("/deleteRecensione")
	public String deleteRecensione(@RequestParam("id") int id) {
		recensioneService.deleteRecensione(recensioneService.findById(id));
		return "redirect:/area_utente";
	}
}