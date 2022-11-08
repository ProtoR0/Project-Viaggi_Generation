package projectwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lavori_in_corso")
public class LavoriInCorsoSp {

	@GetMapping
	public String getPage() {
		
		return "lavorazione_spagnolo";
	}
}
