/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

/**
 * Класс MusicPlayer
 */
public class MusicPlayer {
	private Music music;
// IoC
	public MusicPlayer(Music music) {
		this.music = music;
	}
	public void playMusik() {
		System.out.println("Playing: " + music.getSond());
	}
}