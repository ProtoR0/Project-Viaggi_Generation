package projectwork.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projectwork.model.Account;
import projectwork.service.AccountService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	public String getPage() {
		return "register";
	}
	
	@PostMapping
	public String register(@Valid @ModelAttribute("account") Account account, BindingResult result) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		List<Account> accounts = accountService.findAll();
		
		for (Account a : accounts) {
			if(a.getUsername().equals(account.getUsername())) {
				result.addError(new FieldError("account", "username", "Username giá esistente"));
				return "register";
			}
		}
		
		accountService.saveAccount(account);
		
		return "redirect:/login";
	}
}
