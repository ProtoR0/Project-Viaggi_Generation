package projectwork.controller;

import java.util.List;

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
	public String getPage(@RequestParam(name = "destinazione", required = false) String destinazione , Model model) {
		
		List<Recensione> recensioni = destinazione != null ? recensioneService.findByDestinazione(destinazione) : recensioneService.findAll() ;
			
		model.addAttribute("recensioni", recensioni);
			
		recensioni = recensioneService.findAll();
		
		return "home";
	}
}
