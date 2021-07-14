/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

	@Autowired
	@Qualifier("classicalMusic")
	private Music music;

	public String playMusic() {
		return "Playing: " + music.getSong();
	}
}