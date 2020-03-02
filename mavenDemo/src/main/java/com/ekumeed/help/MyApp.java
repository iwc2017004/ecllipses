package com.ekumeed.help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@Configuration
//@PropertySource({"classpath:database.properties","classpath:email.properties"})
public class MyApp {
	
	public static void main(String[] args) {
		 SpringApplication.run(MyApp.class, args);
				
	}
	
}
