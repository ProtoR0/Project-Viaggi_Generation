package projectwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lavora_con_noi")
public class LavoraConNoiController {

			@GetMapping
			public String getPage() {
							
				
				return "lavora_con_noi";
			}
}
