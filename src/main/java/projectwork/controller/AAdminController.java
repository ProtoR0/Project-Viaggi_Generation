package projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projectwork.model.Account;
import projectwork.model.Admin;
import projectwork.service.AccountService;
import projectwork.service.AdminService;
import projectwork.service.RecensioneService;

@Controller
@RequestMapping("/area_admin")
public class AAdminController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RecensioneService recensioneService;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public String getPage(HttpSession session, Model model) {
		
		if(session.getAttribute("admin") != null) {
		 Admin admin = (Admin) session.getAttribute("admin");
		
			if(adminService.findByUsername(admin.getUsername()) != null) {
					
				model.addAttribute("Utenti", accountService.findAll());
				model.addAttribute("Recensioni", recensioneService.findByPubblicato(true));
				boolean lavoro = recensioneService.findByPubblicato(false) != null ? true : false;
				model.addAttribute("RecensioniDaVerificare", lavoro);
				
				return "area_admin";
			}
		}
		
		return "redirect:/home";
	}
}
