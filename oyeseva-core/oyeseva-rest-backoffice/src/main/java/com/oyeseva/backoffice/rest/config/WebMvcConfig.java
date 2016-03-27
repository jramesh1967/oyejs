package com.oyeseva.backoffice.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.oyeseva.backoffice.rest.controller.PingController;

@EnableWebMvc
@ComponentScan (basePackageClasses = PingController.class)
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setPrefixJson(true);
		return jsonView;
	}
}
