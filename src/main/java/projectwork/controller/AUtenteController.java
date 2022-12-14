package projectwork.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		session.removeAttribute("id_recensione");
		if(session.getAttribute("account") != null) {
			
			Account account = (Account) session.getAttribute("account");
			List<Recensione> recensioni =  recensioneService.findByAccount(account);
			
			for (Recensione recensione : recensioni) {
				recensione.setDurata();
			}
			
			model.addAttribute("recensioni", recensioni);
			model.addAttribute("account", account);
			model.addAttribute("inserisciFoto", inserisciFoto != null ? true : false);
			if(id != null) {
				model.addAttribute("recensione", recensioneService.findById(id));
				session.setAttribute("id_recensione", id);
			}else {
				model.addAttribute("recensione", new Recensione());
			}
			
			
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
			if(session.getAttribute("id_recensione") == null) {
				session.setAttribute("id_recensione", recensioneService.maxId());
			}
			return "redirect:/area_utente?id=" + session.getAttribute("id_recensione") + "&if=true";
		}
		
		model.addAttribute("account", session.getAttribute("account"));
		model.addAttribute("inserisciFoto", false);
		model.addAttribute("recensioni", (List<Recensione>) recensioneService.findByAccount( (Account)session.getAttribute("account")));
		
		return "area_utente";
	}
	
	@PostMapping("/inserimentoFoto")
	public String inserisciFoto(HttpSession session, @RequestParam(name = "foto", required = false) List<MultipartFile> files) {
		if(files == null) {
			Recensione recensione = recensioneService.findById((int) session.getAttribute("id_recensione"));
			recensione.setImage(false);
			return "redirect:/area_utente";
		}
		
		if(files.size()>3) {
			List<MultipartFile> temp = new ArrayList<MultipartFile>();
			temp.add(files.get(0));
			temp.add(files.get(1));
			temp.add(files.get(2));
			files = temp;
		}
	
		int i=1;
		
		for (MultipartFile file : files) {
			String rootDir = session.getServletContext().getRealPath("/");
			String filePath = rootDir + "static\\fotoRecensioni\\" + session.getAttribute("id_recensione") + "_" + i + ".png";
	        try {
	            file.transferTo(new File(filePath));
	        } catch (IllegalStateException | IOException e) {
	            e.printStackTrace();
	            
	        }
		     
	        i++;
	        
		}
		
		session.removeAttribute("id_recensione");
		return "redirect:/area_utente";
	}

}
