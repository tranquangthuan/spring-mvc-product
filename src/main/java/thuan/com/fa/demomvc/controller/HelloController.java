package thuan.com.fa.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping(value = "/hello")
	public String home(@RequestParam(required = false) String msg, Model model) {
		model.addAttribute("msg", msg);
		System.out.println("Fetch Flash Attributes By using Model");
		System.out.println("Book Name:" + model.asMap().get("book"));
		System.out.println("Writer:" + model.asMap().get("writer"));

		return "hello";
	}

}
