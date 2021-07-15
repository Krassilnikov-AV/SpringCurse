/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("ru.krasilnikov.spring")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
}