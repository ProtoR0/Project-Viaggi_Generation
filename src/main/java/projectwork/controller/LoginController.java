package projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectwork.model.Account;
import projectwork.model.Admin;
import projectwork.service.AccountService;
import projectwork.service.AdminService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AdminService adminService;

	@GetMapping
	public String getPage(HttpSession session) {
		if(session.getAttribute("account") != null) {
			session.removeAttribute("account");
		}
		if(session.getAttribute("admin") != null) {
			session.removeAttribute("admin");
		}
		return "login";
	}
	
	@PostMapping
	public String login(@RequestParam(name = "username", required = false) String username, @RequestParam(name = "password", required = false) String password,@RequestParam("tipo") String type, HttpSession session, Model model) {
		
		
		if(username != null && password != null) {
			if(type.equals("Normale")) {										// Login per account normale
			
				Account account = accountService.findByUsername(username);
				
				if(account != null) {
					
					if(account.getPassword().equals(password)) {
						session.setAttribute("account", account);
						return "redirect:/area_utente";
					}
					model.addAttribute("passwordError", true);
				}else {
					model.addAttribute("usernameError", true);	
				}	
				
			}else if(type.equals("Admin")) {									// Login per account admin
				Admin admin = adminService.findByUsername(username);
				
				if(admin != null) {
					
					if(admin.getPassword().equals(password)) {
						session.setAttribute("admin", admin);
						return "redirect:/area_admin";
					}
					model.addAttribute("passwordError", true);
				}else {
					model.addAttribute("usernameError", true);	
				}	
					
				}
			
			return "login";
			}
		
		return "redirect:/login";

	}
}
