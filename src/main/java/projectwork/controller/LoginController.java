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
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		
		Account account = accountService.findByUsername(username);
		
		if(account != null) {
			
			session.setAttribute("account", account);
		
			if(account.getPassword() != password) {
				return "redirect:/login";
			}
		}
		return "home";
	}
}
