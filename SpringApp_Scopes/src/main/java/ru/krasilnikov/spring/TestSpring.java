/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");

		MusicPlayer firstmMsicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
		MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
// проверка указания объектов на один и тот же участок памяти
		// тем самым убедимся что по умолчанию Singelton запускает
		boolean comparison = firstmMsicPlayer == secondMusicPlayer;


		System.out.println(comparison);

		System.out.println(firstmMsicPlayer);
		System.out.println(secondMusicPlayer);
// при установке громкости на первом объекте, у второго установится такая же громкость
		firstmMsicPlayer.setVolume(10);

		System.out.println(firstmMsicPlayer.getVolume());
		System.out.println(secondMusicPlayer.getVolume());
		//
//		System.out.println(musicPlayer.getName());
//		System.out.println(musicPlayer.getVolume());
		context.close();
	}
}