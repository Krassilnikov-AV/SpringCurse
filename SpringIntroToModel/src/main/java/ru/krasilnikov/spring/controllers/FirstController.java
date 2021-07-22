/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/first")
public class FirstController {

	@GetMapping("/hello")
	public String helloPage(@RequestParam(value = "name", required = false) String name,
							@RequestParam(value = "surname", required = false) String surname,
							Model model) {
//		System.out.println("Hello, " + name + " " + surname);

		model.addAttribute("massage", "Hello, " + name + " " + surname);
		return "first/hello";
	}

	@GetMapping("/goodbye")
	public String goodByePage() {
		return "first/goodbye";
	}
}