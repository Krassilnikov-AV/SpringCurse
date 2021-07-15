/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import javax.annotation.*;
import java.util.*;

//@Component
//@Scope("singleton")
public class ClassicalMusic implements Music {
@PostConstruct
	public void doMyInit() {
		System.out.println("Doing my initialization");
	}
	@PreDestroy
	public void doMyDestroy() {
		System.out.println("Doing my destruction");
	}
	private List<String> songs=new ArrayList<>();
	// Блок инициализации объекта (англ. Instance initialization block)
	// Выполняется каждый раз, когда создается объект класса
	{
		songs.add("Swan Lake");
		songs.add("The Nutcracker");
		songs.add("The whole camp is asleep");
	}
	@Override
	public List<String> getSong() {
		return songs;
	}
}