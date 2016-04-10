package com.oyeseva.delivery.rest.config;

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
		System.out.println("***Starting oyeseva-rest-delivery application ***");
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(WebMvcConfig.class);

		Dynamic dynamic = servletContext.addServlet("dispatcherServlet",
				new DispatcherServlet(webApplicationContext));
		dynamic.addMapping("/api/v1/delivery/*");
		dynamic.setLoadOnStartup(1);

		/*
		 * // create a security constraint element
		 * 
		 * HttpConstraintElement constraint = new HttpConstraintElement();
		 * 
		 * List methodConstraints =
		 * 
		 * new ArrayList();
		 * 
		 * // Allow GET access only to a user in role javaee
		 * 
		 * methodConstraints.add(new HttpMethodConstraintElement("GET",
		 * 
		 * new HttpConstraintElement(TransportGuarantee.NONE, new String[] {
		 * "admin" })));
		 * 
		 * // Allow POST access only to a user in role javaee and when the //
		 * Transport is Secure
		 * 
		 * methodConstraints.add(new HttpMethodConstraintElement("POST",
		 * 
		 * new HttpConstraintElement(TransportGuarantee.CONFIDENTIAL, new
		 * String[] { "admin" })));
		 * 
		 * // Deny Trace access.
		 * 
		 * methodConstraints.add(new HttpMethodConstraintElement("TRACE",
		 * 
		 * new HttpConstraintElement(EmptyRoleSemantic.DENY)));
		 * 
		 * ServletSecurityElement servletSecurityElement =
		 * 
		 * new ServletSecurityElement(constraint, methodConstraints);
		 * 
		 * // set the Servlet Security Constraints on
		 * ServletRegistration.Dynamic
		 * 
		 * dynamc.setServletSecurity(servletSecurityElement);
		 */
	}

}
