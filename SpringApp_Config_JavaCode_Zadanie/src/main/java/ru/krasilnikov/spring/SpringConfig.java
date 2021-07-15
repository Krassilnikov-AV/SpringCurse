/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("ru.krasilnikov.spring")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
	@Bean
	public ClassicalMusic classicalMusic() {
		return new ClassicalMusic();
	}
	@Bean
	public RockMusic rockMusic() {
		return new RockMusic();
	}

	@Bean
	public MusicPlayer musicPlayer() {
		return new MusicPlayer(rockMusic(), classicalMusic());
	}
	@Bean
	public Computer computer() {
		return new Computer(musicPlayer());
	}
}