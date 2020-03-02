package com.ekumeed.help.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration

public class MyConfiguration {
	@Value("$(ekumeedhelp.name)")
	public String name;
	
	@Value("$(ekumeedhelp.password)")
	public String password;
	
	@Value("$(contact.emailid)")
	public String email;
	
	@Value("$(contact.phoneno)")
	public String phoneno;
	
	@Bean
	public Database getdetails() {
		Database db = new Database();
		
		return db;
	}
	@Bean
	public Contact getContact() {
		Contact cx = new Contact();
		cx.setEmailid(email);
		cx.setPhoneno(phoneno);
		return cx;
	}
	
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		return new PropertySourcesPlaceholderConfigurer();
	}*/

}
