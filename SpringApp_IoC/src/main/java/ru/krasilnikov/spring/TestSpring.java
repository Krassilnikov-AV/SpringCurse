/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Класс TestSpring
 */
public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
		TestBean testBean = context.getBean("testBean", TestBean.class);

		System.out.println(testBean.getName());

		context.close();
	}
}