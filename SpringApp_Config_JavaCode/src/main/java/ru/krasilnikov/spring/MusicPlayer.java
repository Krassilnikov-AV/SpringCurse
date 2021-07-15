/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
	@Value("${musicPlayer.name}")
	private String name;

	@Value("${musicPlayer.volume}")
	private int volume;

	public String getName() {return name;	}

	public int getVolume() {return volume;	}

	private Music music1;
	private Music music2;

	@Autowired
	public void playMusic(@Qualifier("rockMusic") Music music1,
						  @Qualifier("classicalMusic") Music music2) {
		this.music1=music1;
		this.music2=music2;
	}

	public String playMusic() {
		return "Playing: " + music1.getSong() + ", " + music2.getSong();
	}
}