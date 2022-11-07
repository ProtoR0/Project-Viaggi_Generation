package projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectwork.model.Account;
import projectwork.model.Recensione;
import projectwork.service.RecensioneService;

@Controller
@RequestMapping("/area_utente")
public class AUtenteController {
	
	@Autowired
	private RecensioneService recensioneService;
	
	
	@GetMapping
	public String getPage(Model model, HttpSession session, @RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "if", required = false) Boolean inserisciFoto) {
		if(session.getAttribute("account") != null) {
			
			Account account = (Account) session.getAttribute("account");
			
			model.addAttribute("recensioni", recensioneService.findByAccountANDPubblicato(account, 1));
			model.addAttribute("nome", account.getUsername());
			model.addAttribute("inserisciFoto", inserisciFoto != null ? true : false);
			model.addAttribute("recensione", id != null ? recensioneService.findById(id) : new Recensione());
			
			return "area_utente";
		}
		return "redirect:/login";
	}
	
	@PostMapping
	public String registraRecensione(@ModelAttribute("recensione") Recensione recensione, Model model) {
		recensioneService.saveRecensione(recensione);
		return "redirect:/area_utente?id=" + recensioneService.maxId() + "&if=true";
	}
}
