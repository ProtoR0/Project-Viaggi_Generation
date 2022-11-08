package projectwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/chi_siamo")
public class ChiSiamoController {

		@GetMapping
		public String getPage() {
						
			
			return "chi_siamo";
		}
}

