package projectwork.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projectwork.model.Account;
import projectwork.service.AccountService;

@Controller
@RequestMapping("/registrazione")
public class RegistrazioneController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	public String getPage(Model model) {
		model.addAttribute("newAccount", new Account());
		return "registrazione";
	}
	
	@PostMapping
	public String register(@Valid @ModelAttribute("newAccount") Account account, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "registrazione";
		}
		
		List<Account> accounts = accountService.findAll();
		
		for (Account a : accounts) {
			if(a.getUsername().equals(account.getUsername())) {
				model.addAttribute("usernameTaken", true);
				return "registrazione";
			}
		}
		
		accountService.saveAccount(account);
		
		return "redirect:/login?newAccount=1";
	}
}
