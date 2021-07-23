/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.krasilnikov.spring.dao.PersonDAO;
import ru.krasilnikov.spring.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

	private final PersonDAO personDAO;

	public PeopleController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@GetMapping()
	public String index(Model model) {
		// получим всех людей из DAO и передадим на отображение в представлении
		model.addAttribute("people", personDAO.index());
		return "people/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
// получим одного человека по id из DAO и передадим на отображение в представление
		model.addAttribute("person", personDAO.show(id));

		return "people/show";
	}

	@GetMapping("/new")
//	public String newPerson(Model model) {
//		model.addAttribute("person", new Person());

	/** будет работать так же, как и в предыдущем случае    **/
	public String newPerson(@ModelAttribute("person") Person person) {

		return "people/new";
	}

	@PostMapping()
	public String create(@ModelAttribute("person") Person person) {
		personDAO.save(person);
		return "redirect:/people";
	}

}