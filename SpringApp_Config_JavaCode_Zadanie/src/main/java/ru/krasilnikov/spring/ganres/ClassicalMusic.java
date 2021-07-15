/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.ganres;

import ru.krasilnikov.spring.Music;

public class ClassicalMusic implements Music {

	@Override
	public String getSong() {
		return "The Nutcracker";
	}
}