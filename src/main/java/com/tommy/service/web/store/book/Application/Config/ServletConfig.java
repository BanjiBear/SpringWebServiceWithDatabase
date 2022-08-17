package com.tommy.service.web.store.book.Application.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
@ComponentScan(basePackages = "com.tommy")
@EnableWebMvc
public class ServletConfig implements WebMvcConfigurer{
	
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry
			.addResourceHandler("/resource/**")
			.addResourceLocations("/resource/");
	}*/
}