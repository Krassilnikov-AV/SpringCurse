/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.config;

import org.springframework.context.annotation.*;
import ru.krasilnikov.spring.*;
import ru.krasilnikov.spring.ganres.*;

import java.util.*;

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
	public RapMusic rapMusic() {
		return new RapMusic();
	}
	@Bean
	public List<Music>  musicList() {
		return Arrays.asList(classicalMusic(), rockMusic(), rapMusic());
	}
	@Bean
	public MusicPlayer  musicPlayer() {
		return new MusicPlayer(musicList());
	}
	@Bean
	public Computer computer() {
		return new Computer(musicPlayer());
	}

}