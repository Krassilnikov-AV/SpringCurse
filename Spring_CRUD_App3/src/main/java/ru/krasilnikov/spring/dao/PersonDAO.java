/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.dao;

import org.springframework.stereotype.Component;
import ru.krasilnikov.spring.models.Person;

import java.util.*;

@Component
public class PersonDAO {
	// в качестве БД пока будем использовать список ArrayList
	private static int PEOPLE_COUNT;
	private List<Person> people;

	{
		people = new ArrayList<>();

		people.add(new Person(++PEOPLE_COUNT, "Tom"));
		people.add(new Person(++PEOPLE_COUNT, "Jery"));
		people.add(new Person(++PEOPLE_COUNT, "Nikola"));
		people.add(new Person(++PEOPLE_COUNT, "Padington"));
		people.add(new Person(++PEOPLE_COUNT, "Sanya"));
	}

	public List<Person> index() {
		return people;
	}

	public Person show(int id) {
		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
	}

	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}
	public void update(int id, Person updatePerson) {
		Person personToBeUpdated = show(id);

		personToBeUpdated.setName(updatePerson.getName());

	}

	public void delete(int id) {
		people.removeIf(p -> p.getId() == id);
	}
}