/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.ganres;

import ru.krasilnikov.spring.Music;

public class RapMusic implements Music {

//	private List<String> songs=new ArrayList<>();
//	// Блок инициализации объекта (англ. Instance initialization block)
//	// Выполняется каждый раз, когда создается объект класса
//	{
//		songs.add("All Of The Lights");
//		songs.add("Lose Yourself");
//		songs.add("Electric Relaxation");
//	}
	@Override
	public String getSong() {
		return "Lose Yourself";
	}
}