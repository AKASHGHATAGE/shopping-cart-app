package com.prowings.shoppingcartapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

	@GetMapping("/hello")
	public String Hello() {
		return "Hello world";
	}
}
