/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

/**
 * Класс ClassicalMusic
 */
public class ClassicalMusic implements Music {
	@Override
	public String getSond() {
		return "Beethoven";
	}
}