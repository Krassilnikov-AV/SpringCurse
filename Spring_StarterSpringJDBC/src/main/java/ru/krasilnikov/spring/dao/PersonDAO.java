/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.dao;

import org.springframework.stereotype.Component;
import ru.krasilnikov.spring.models.Person;

import java.sql.*;
import java.util.*;

@Component
public class PersonDAO {

	private static int PEOPLE_COUNT;
	private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "alex159";

	private static Connection connection;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Person> index() {
		List<Person> people = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			String SQL = "Select*FROM Person";
			ResultSet resultSet = statement.executeQuery(SQL);
			while (resultSet.next()) {
				Person person = new Person();

				person.setId(resultSet.getInt("id"));
				person.setName(resultSet.getString("name"));
				person.setEmail(resultSet.getString("email"));
				person.setAge(resultSet.getInt("age"));

				people.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}

	public Person show(int id) {
//		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
		return null;
	}

	public void save(Person person) {
//		person.setId(++PEOPLE_COUNT);
//		people.add(person);
	}

	public void update(int id, Person updatedPerson) {
//		Person personToBeUpdated = show(id);
//
//		personToBeUpdated.setName(updatedPerson.getName());
//		personToBeUpdated.setAge(updatedPerson.getAge());
//		personToBeUpdated.setEmail(updatedPerson.getEmail());
	}

	public void delete(int id) {
//		people.removeIf(p -> p.getId() == id);
	}
}