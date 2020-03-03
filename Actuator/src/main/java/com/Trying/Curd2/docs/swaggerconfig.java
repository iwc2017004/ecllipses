package com.Trying.Curd2.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import antlr.Version;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerconfig {
	
	
	  @Bean public Docket api() { 
		  return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any
	  ()).paths(PathSelectors.any()).build().pathMapping("/").apiInfo(apiDetails());
		  }
	  
	  
	  private ApiInfo apiDetails() {
		  return new ApiInfoBuilder().title("Student API Docs")
				  .description("Student API description")
				  .termsOfServiceUrl("student termsOfServiceUrl")
				  .license("student license")
				  .licenseUrl("/test").contact(new Contact("praveen","www.google.com" , "iwc2017004@gmail.com"))
				  .version("1.0").build();
	  }
	   
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
	  
	  
}
