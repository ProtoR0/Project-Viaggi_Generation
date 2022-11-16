package projectwork.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectwork.helper.DeleteItem;
import projectwork.model.Account;
import projectwork.model.Recensione;
import projectwork.service.AccountService;
import projectwork.service.RecensioneService;

@Controller
@RequestMapping("/deleteconfirm")
public class DeleteAlertController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RecensioneService recensioneService;
	
	private projectwork.helper.DeleteItem deleteItem;
	
	@GetMapping
	public String getPage(Model model, @RequestParam("id") int id, @RequestParam("type") String type, HttpSession session) {
		setDeleteItem(id, type, session);
		model.addAttribute("title", "Delete confirm");
		model.addAttribute("deletable", deleteItem);
		return "delete-alert";
	}
	
	private void setDeleteItem(int id, String type, HttpSession session) {
		String redirect = "";
		switch (type) {
		case "account":
			Account account = accountService.findById(id);
			deleteItem = new DeleteItem(id, type, account.getUsername(), "/area_admin");
			break;

		case "recensione":
			Recensione recensione = recensioneService.findById(id);
			if(session.getAttribute("account") != null) {
				redirect = "/area_utente";
			}else if(session.getAttribute("admin") != null) {
				redirect = "/area_admin";
			}
			deleteItem = new DeleteItem(id, type, recensione.getTitolo(), redirect);
			
		}
	}
	
	@GetMapping("/deleteItem")
	private String deleteItem(HttpSession session) {
		switch(deleteItem.getType()) {
		case "recensione":
			Recensione recensione = recensioneService.findById(deleteItem.getId());
			recensioneService.deleteRecensione(recensione);
			
			for(int cont = 1; cont < 4; cont++) {
				String rootDir = session.getServletContext().getRealPath("/");
				String filePath = rootDir + "static\\articles\\" + recensione.getId() + "_" + cont + ".png";
				
				File file = new File(filePath);
				file.delete();
				
			}
			
 			break;
			
		case "account":
			accountService.removeAccount(accountService.findById(deleteItem.getId()));

		}
		
		return "redirect:" + deleteItem.getRedirect() ;
	}
}
