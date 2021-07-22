/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

	@GetMapping("/hello")
	public String helloPage(HttpServletRequest request){
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");


		System.out.println("Hello, "+ name+ " "+surname);
		return "first/hello";
	}

	@GetMapping("/goodbye")
	public String goodByePage(){
		return "first/goodbye";
	}
}