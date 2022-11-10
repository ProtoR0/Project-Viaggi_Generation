package projectwork.controller;

import java.io.File;
import java.util.ArrayList;
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
@RequestMapping("/recensione")
public class DettagliRecensioneController {
	
	@Autowired
	private RecensioneService recensioneService;
	
	@GetMapping
	public String getPage(@RequestParam("id") Integer id, Model model, HttpSession session) {
		if(recensioneService.findById(id) == null) {
			return "redirect:/home";
		}
		
		if(recensioneService.findById(id).getPubblicato() != 1 && session.getAttribute("admin") == null) {	// se la recensione non é pubblicata ritorna alla home | se é un admin a visualizzare continua
			return "redirect:/home";
		}
		
		Recensione recensione = recensioneService.findById(id);
		recensione.setDurata();
		
		List<String> images = new ArrayList<>();
		
		for(int cont =1; cont < 4; cont++) {
			String rootDir = session.getServletContext().getRealPath("/");
			String filePath = rootDir + "static\\fotoRecensioni\\" + id + "_" + cont + ".png";
			File file = new File(filePath);
			
			if(file.exists()) {
				images.add(id+"_"+cont+".png");
				recensione.setImage(true);
			}
			
		}

		
		model.addAttribute("account", session.getAttribute("account") != null ? session.getAttribute("account") : null);
		model.addAttribute("admin", session.getAttribute("admin") != null ? session.getAttribute("admin") : null);
		model.addAttribute("recensione", recensione);
		model.addAttribute("images", recensione.isImage() ? images : null);
		
		return "dettagli_recensione";
	}
}
