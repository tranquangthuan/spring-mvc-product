package thuan.com.fa.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "redirect")
public class RedirectController {

	@GetMapping("/no-param")
	public String no() {
		return "redirect:/hello";
	}

	@GetMapping("/param")
	public RedirectView param(RedirectAttributes redirectAttrs) {
		redirectAttrs.addAttribute("msg", "Hello World!");
		redirectAttrs.addFlashAttribute("book", "Java");
		redirectAttrs.addFlashAttribute("writer", "Tom");

		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/hello");
		return redirectView;
	}

}
