/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;
//@Component
public class Computer {
	private int id = 1;
	private MusicPlayer musicPlayer;

//	@Autowired
	public Computer(MusicPlayer musicPlayer) {
		this.musicPlayer = musicPlayer;
	}

	public String toString() {
		return "Computer" + this.id + " " + this.musicPlayer.playMusic();
	}
}
