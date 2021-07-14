/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
	private Music music;

	@Autowired
	public MusicPlayer(Music music) {
		this.music = music;
	}

	public void playMusik() {
		System.out.println("Playing: " + music.getSond());
	}
}