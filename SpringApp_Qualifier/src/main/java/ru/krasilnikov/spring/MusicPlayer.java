/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {

	private ClassicalMusic classicalMusic;
	private RockMusic rockMusic;

	public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
		this.classicalMusic = classicalMusic;
		this.rockMusic = rockMusic;
	}

	public void playMusic(MusicGenre genre) {
		Random random=new Random();
		int randomNumber = random.nextInt(3);
		if(genre == MusicGenre.CLASSICAL) {
			// случайная классическая песня
			System.out.println(classicalMusic.getSong().get(randomNumber));
		} else {
			System.out.println(rockMusic.getSong().get(randomNumber));
		}
	}
}