package projectwork.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String registraRecensione(@Valid @ModelAttribute("recensione") Recensione recensione, BindingResult result, Model model, HttpSession session ) {
		
		if(!result.hasErrors()) {
			recensione.setPubblicato(0);
			recensione.setAccount((Account) session.getAttribute("account"));
			recensioneService.saveRecensione(recensione);
			session.setAttribute("id_recensione", recensioneService.maxId());
			return "redirect:/area_utente?id=" + session.getAttribute("id_recensione") + "&if=true";
		}
		return "redirect:/area_utente";
	}
	
	@GetMapping("/inserimentoFoto")
	public String inserisciFoto(@RequestParam(name = "foto", required = false) MultipartFile[] files, HttpSession session) {
		if(files == null) {
			Recensione recensione = recensioneService.findById((int) session.getAttribute("id_recensione"));
			recensione.setImage(false);
			return "redirect:/area_utente";
		}
		
		int i = 1;
		
		for(MultipartFile file : files) {
			String rootDir = session.getServletContext().getRealPath("/");
			String filePath = rootDir + "static\\fotoRecensioni\\" + session.getAttribute("id_recensione") + "_" + i + ".png";
	        try {
	            file.transferTo(new File(filePath));
	        } catch (IllegalStateException | IOException e) {
	            e.printStackTrace();
	            
	        }
	        
	        i++;
		}
		
		return "redirect:/area_utente";
	}
}
