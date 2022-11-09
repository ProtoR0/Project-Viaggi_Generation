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
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private RecensioneService recensioneService;
	
	@GetMapping
	public String getPage(@RequestParam(name = "destinazione", required = false) String destinazione , Model model, HttpSession session) {
		
		List<Recensione> recensioni = destinazione != null ? recensioneService.findByDestinazioneANDPubblicato(destinazione, 1) : recensioneService.findByPubblicato(1);
		
		for (Recensione recensione : recensioni) {
			recensione.setDurata();
		}
		
		model.addAttribute("recensioni", recensioni);
		model.addAttribute("account", session.getAttribute("account") != null ? session.getAttribute("account") : null);
		
		return "home";
	}
}
