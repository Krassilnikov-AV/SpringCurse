/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.ganres;

import ru.krasilnikov.spring.Music;

//@Component
public class RockMusic implements Music {
//	private List<String> songs=new ArrayList<>();
//	// Блок инициализации объекта (англ. Instance initialization block)
//	// Выполняется каждый раз, когда создается объект класса
//	{
//		songs.add("Группа крови");
//		songs.add("Пачка сигарет");
//		songs.add("Как на войне");
//	}
	@Override
	public String getSong() {
		return "Группа крови";
	}
}