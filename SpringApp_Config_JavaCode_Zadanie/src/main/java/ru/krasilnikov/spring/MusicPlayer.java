/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.beans.factory.annotation.Value;

import java.util.*;

public class MusicPlayer {
	@Value("${musicPlayer.name}")
	private String name;

	@Value("${musicPlayer.volume}")
	private int volume;

	public String getName() {return name;	}

	public int getVolume() {return volume;	}

	private List<Music> musicList;

	public MusicPlayer(List<Music> musicList) {
		this.musicList=musicList;
	}

	public String playMusic() {
		Random random = new Random();

		return "Playing: " + musicList.get(random.nextInt(musicList.size())).getSong()
			+ " with volume " + this.volume;
	}
}