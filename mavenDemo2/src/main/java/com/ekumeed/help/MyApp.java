package com.ekumeed.help;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ekumeed.help.ctrl.Contact;
import com.ekumeed.help.ctrl.Database;

@SpringBootApplication
@Configuration
//@PropertySource({"classpath : database.properties","classpath : email.properties"})
@PropertySources({
	@PropertySource("classpath : database.properties"),
	@PropertySource("classpath : email.properties")
	
})
public class MyApp {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(MyApp.class, args);
		Database db = (Database)ctx.getBean(Database.class);
		System.out.println("Name : " + db.getName());
		System.out.println("Password : " + db.getPassword());
		
		Contact cx = (Contact)ctx.getBean(Contact.class);
		System.out.println("Email : " + cx.getEmailid());
		System.out.println("Phone  no  : " + cx.getPhoneno());
				
	}
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
		db.setName(name);
		db.setPassword(password);
		return db;
	}
	@Bean
	public Contact getContact() {
		Contact cx = new Contact();
		cx.setEmailid(email);
		cx.setPhoneno(phoneno);
		return cx;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
