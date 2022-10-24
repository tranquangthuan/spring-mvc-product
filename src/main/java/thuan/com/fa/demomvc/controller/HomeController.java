package thuan.com.fa.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("home")
	public String home() {
		return "home";
	}

	@GetMapping(value = "home1")
	public String home1(Model model) {
		model.addAttribute("message", "message from method home 1");
		return "home";
	}
}
