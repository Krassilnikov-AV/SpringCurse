/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

/**
 * Класс ClassicalMusic
 */
public class ClassicalMusic implements Music {

//	public static ClassicalMusic getClassicalMusic() {
//		return new ClassicalMusic();
//	}
	public  void doMyInit() {
		System.out.println("Doing my initialization");
	}

	public  void doMyDestroy() {
		System.out.println("Doing my destruction ");
	}
	@Override
	public String getSond() {
		return "Beethoven";
	}
}