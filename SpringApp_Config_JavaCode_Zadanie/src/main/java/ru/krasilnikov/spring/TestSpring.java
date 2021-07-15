/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.krasilnikov.spring.config.SpringConfig;

public class TestSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(SpringConfig.class);

		MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(musicPlayer.playMusic());
		context.close();
	}
}