package projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectwork.model.Account;
import projectwork.service.AccountServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AccountServiceImpl accountService;

	@GetMapping
	public String getPage() {
		return "login";
	}
	
	@PostMapping
	public String login(@RequestParam(name = "username", required = false) String username, @RequestParam(name = "password", required = false) String password, HttpSession session) {
		
		
		if(username != null && password != null) {
			Account account = accountService.findByUsername(username);
			
			if(account != null) {
				
				System.out.println(account.getPassword());
				
				if(account.getPassword().equals(password)) {
					session.setAttribute("account", account);
					return "redirect:/area_utente";
				}
			}
			return "redirect:/home";
		}
		
		return "redirect:/login";

	}
}
