/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

/**
 * Класс ClassikalMusic
 */
public class ClassikalMusic implements Music {
	@Override
	public String getSond() {
		return "Beethoven";
	}
}