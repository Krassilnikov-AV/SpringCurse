/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
//		Music music = context.getBean("rockMusic", Music.class);
//		MusicPlayer musicPlayer = new MusicPlayer(music);
//		musicPlayer.playMusik();
//		Music music2 = context.getBean("classicalMusic", Music.class);
//		MusicPlayer musicPlayer2 = new MusicPlayer(music2);
//		musicPlayer2.playMusik();

//		MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//		musicPlayer.playMusic();

		Computer computer =context.getBean("computer", Computer.class);
		System.out.println(computer);
		context.close();
	}
}