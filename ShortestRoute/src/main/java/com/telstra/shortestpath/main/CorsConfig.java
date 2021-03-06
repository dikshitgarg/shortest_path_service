
package com.telstra.shortestpath.main;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class CorsConfig  extends WebMvcConfigurerAdapter {
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	        	
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	            	registry.addMapping("/**")
	                		.allowedOrigins("*")
	                		.allowedMethods("*")
	                		.allowedHeaders("*");
	            	 
	   
	            }
	            public void addResourceHandlers(ResourceHandlerRegistry registry){
	          registry.addResourceHandler("/webjars/**")
	                  .addResourceLocations("classpath:/META-INF/resources/webjars/");
	            }
	        };
	    }
}
