package com.oyeseva.customer.rest.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class OyesevaCustomerRESTInitializer implements WebApplicationInitializer {

	// @Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		System.out.println("***Starting oyeseva-rest-customer application ***");

		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("/WEB-INF/classes/spring.xml");

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/api/v1/customer/*");
	}
}
