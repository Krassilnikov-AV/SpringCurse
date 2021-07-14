/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

public class MusicPlayer {
	private Music music;

	private String name;
	private int volume;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	// IoC
	public MusicPlayer(Music music) {
		this.music = music;
	}

	public MusicPlayer() {}

	public void setMusic(Music music) {
		this.music = music;
	}


	public void playMusik() {
		System.out.println("Playing: " + music.getSond());
	}
}