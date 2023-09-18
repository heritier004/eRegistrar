package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Configuration
public class ERegistrarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERegistrarApplication.class, args);
	}

	@Bean
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}

}
