package projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
			model.addAttribute("Utenti", accountService.findAll());
			model.addAttribute("Recensioni", recensioneService.findByPubblicato(true));
			boolean lavoro = recensioneService.findByPubblicato(false) != null ? true : false;
			model.addAttribute("RecensioniDaVerificare", lavoro);
			
			return "area_admin";
		}
		
		return "redirect:/home";
	}
}
