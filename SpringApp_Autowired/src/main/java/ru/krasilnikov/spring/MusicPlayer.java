/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

	private ClassicalMusic classicalMusic;
	private RockMusic rockMusic;

	@Autowired
	public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
		this.classicalMusic = classicalMusic;
		this.rockMusic = rockMusic;
	}

	public void playMusik() {
		System.out.println("Playing: " + classicalMusic.getSong());
		System.out.println("Playing: " + rockMusic.getSong());
	}
}