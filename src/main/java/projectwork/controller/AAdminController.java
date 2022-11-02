package projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projectwork.model.Account;

@Controller
@RequestMapping("/area_admin")
public class AAdminController {
	
	@GetMapping
	public String getPage(HttpSession session) {
		
		if(session.getAttribute("account") != null) {
		 Account account = (Account) session.getAttribute("acccount");
		
			if(account.isAdmin()) {
				return "area_admin";		
			}
		}
		
		return "redirect:/home";
	}
}
