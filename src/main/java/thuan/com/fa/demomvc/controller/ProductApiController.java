package thuan.com.fa.demomvc.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thuan.com.fa.demomvc.model.NewProduct;

@RestController
@RequestMapping("api")
public class ProductApiController {

	@GetMapping(value = "/test")
	public String test() {
		return "OKIE1";
	}

	@PostMapping(value = "insert")
	public void insert(@RequestBody @Valid NewProduct product) {
		System.out.println("OK");
	}
}
