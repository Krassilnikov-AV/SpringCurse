/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.krasilnikov.spring.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * Класс MySpringMvcDispatcherServletInitializer
 */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	// запускается при старте Spring приложения
	@Override
	public void onStartup(ServletContext aServletContext) throws ServletException {
		super.onStartup(aServletContext);
		registerHiddenFieldFilter(aServletContext);
	}
// в этом методе добавляем фильтр HiddenHttpMethodFilter
	private void registerHiddenFieldFilter(ServletContext aContext) {
		aContext.addFilter("hiddenHttpMethodFilter",
			new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
	}
}