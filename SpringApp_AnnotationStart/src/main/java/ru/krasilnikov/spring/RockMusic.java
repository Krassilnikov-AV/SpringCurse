/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
	@Override
	public String getSond() {
		return "The Wind Cries Mary";
	}
}