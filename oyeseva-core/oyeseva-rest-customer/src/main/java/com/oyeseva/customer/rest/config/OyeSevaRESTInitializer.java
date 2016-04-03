package com.oyeseva.customer.rest.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.oyeseva.business.service.UserService;
import com.oyeseva.customer.rest.controller.PingController;
import com.oyeseva.customer.rest.controller.UserController;
import com.oyeseva.entity.dao.SampleDAO;
import com.oyeseva.entity.dao.UserDAO;
import com.oyeseva.entity.dao.UserProfileDAO;
import com.oyeseva.service.SampleService;

public class OyeSevaRESTInitializer implements WebApplicationInitializer {

	// @Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		System.out.println("***Starting oyeseva-rest-customer application ***");

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext
				.register(
						WebMvcConfig.class,
						UserController.class,
						PingController.class,
						UserService.class,
						SampleService.class,
						UserDAO.class,
						UserProfileDAO.class,
						SampleDAO.class,
						org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.class,
						org.springframework.orm.jpa.JpaTransactionManager.class);

		Dynamic dynamic = servletContext.addServlet("dispatcherServlet",
				new DispatcherServlet(webApplicationContext));
		dynamic.addMapping("/api/v1/customer/*");
		dynamic.setLoadOnStartup(1);

		/*
		 * // Create the 'root' Spring application context
		 * AnnotationConfigWebApplicationContext rootContext = new
		 * AnnotationConfigWebApplicationContext();
		 * rootContext.register(WebMvcConfig.class);
		 * 
		 * // Manage the lifecycle of the root application context
		 * servletContext.addListener(new ContextLoaderListener(rootContext));
		 * 
		 * // Create the dispatcher servlet's Spring application context
		 * //AnnotationConfigWebApplicationContext webApplicationContext = new
		 * AnnotationConfigWebApplicationContext();
		 * //webApplicationContext.register(WebMvcConfig.class);
		 * 
		 * // Register and map the dispatcher servlet
		 * ServletRegistration.Dynamic dispatcher =
		 * servletContext.addServlet("dispatcherServlet", new
		 * DispatcherServlet(rootContext)); dispatcher.setLoadOnStartup(1);
		 * dispatcher.addMapping("/api/v1/customer/*");
		 */
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
