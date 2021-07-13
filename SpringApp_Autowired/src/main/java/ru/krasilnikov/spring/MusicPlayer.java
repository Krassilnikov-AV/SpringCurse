/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
	private ClassicalMusic classicalMusic;

	@Autowired
	public MusicPlayer(ClassicalMusic classicalMusic) {
		this.classicalMusic = classicalMusic;
	}

	public void playMusik() {
		System.out.println("Playing: " + classicalMusic.getSond());
	}
}