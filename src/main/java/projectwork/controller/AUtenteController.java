package projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projectwork.model.Account;
import projectwork.service.RecensioneService;

@Controller
@RequestMapping("/area_utente")
public class AUtenteController {
	
	@Autowired
	private RecensioneService recensioneService;
	
	
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		if(session.getAttribute("account") != null) {
			
			Account account = (Account) session.getAttribute("account");
			
			model.addAttribute("recensioni", recensioneService.findByAccountANDPubblicato(account));
			model.addAttribute("nome", account.getUsername());
			
			
		}
		return "redirect:/login";
	}
	
	@PostMapping
	public String registraRecensione() {
		return null;
	}
}
