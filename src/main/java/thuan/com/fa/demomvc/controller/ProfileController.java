package thuan.com.fa.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import thuan.com.fa.demomvc.model.User;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

	@GetMapping()
	public String welcome(@SessionAttribute(name = "user", required = false) User user) {
		System.out.println("Profile Controller");
		if (user != null) {
			System.out.println("user Name = " + user.getUserName());
			System.out.println("Password = " + user.getPassword());
		} else {
			System.out.println("user from session is null");
		}
		return "welcome";
	}

}
