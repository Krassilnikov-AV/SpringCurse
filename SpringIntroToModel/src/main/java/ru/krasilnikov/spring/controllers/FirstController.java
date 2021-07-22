/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/first")
public class FirstController {

	@GetMapping("/hello")
//	public String helloPage(HttpServletRequest request){
//		String name = request.getParameter("name");
//		String surname = request.getParameter("surname");

	// в данной конструкции, вывод ошибки, если не указаны параметры запроса
//	public String helloPage(@RequestParam("name") String name,
//							@RequestParam("surname") String surname) {

		// в данной конструкции, устранение вывода ошибки, если не указаны параметры запроса
		public String helloPage(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname) {
		System.out.println("Hello, " + name + " " + surname);
		return "first/hello";
	}

//	@GetMapping("/hello")
//	public String helloPage(@RequestParam("name") String name,
//								   @RequestParam("surname") String surname){
//
//		System.out.println("Hello, "+ name+ " "+surname);
//		return "first/hello";
//	}

	@GetMapping("/goodbye")
	public String goodByePage() {
		return "first/goodbye";
	}
}