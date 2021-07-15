/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClassicalMusic implements Music {

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