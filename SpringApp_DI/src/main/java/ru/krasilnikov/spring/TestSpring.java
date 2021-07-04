/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
//		Music music = context.getBean("musicBean", Music.class);

		// внедрение зависимостей вручную
//		MusicPlayer musicPlayer = new MusicPlayer(music);

		// после внедрения зависимости можно сразу использовать музыкальный плеер
		MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
		musicPlayer.playMusik();

		context.close();
	}
}