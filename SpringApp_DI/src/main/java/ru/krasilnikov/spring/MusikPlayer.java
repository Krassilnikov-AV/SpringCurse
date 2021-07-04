/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

/**
 * Класс MusikPlayer
 */
public class MusikPlayer {
	private Music music;
// IoC
	public MusikPlayer(Music music) {
		this.music = music;
	}
	public void playMusik() {
		System.out.println("Playing: " + music.getSond());
	}
}