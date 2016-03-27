package com.oyeseva.backoffice.rest.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class OyeSevaRESTInitializer implements WebApplicationInitializer {

	//@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		System.out.println("***Starting oyeseva-rest-backoffice application ***");
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(WebMvcConfig.class);

		Dynamic dynamic = servletContext.addServlet("dispatcherServlet",
				new DispatcherServlet(webApplicationContext));
		dynamic.addMapping("/api/v1/backoffice/*");
		dynamic.setLoadOnStartup(1);
	}
}
