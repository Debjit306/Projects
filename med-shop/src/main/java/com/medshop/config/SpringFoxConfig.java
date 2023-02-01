package com.medshop.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

public class SpringFoxConfig {
	//This is for the Authorize button appearing in swagger
	private ApiKey apikey()
	{
		return new ApiKey("JWT", "Authorization", "header");
	}
	
	private SecurityContext securityContext()
	{
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}
	
	private List<SecurityReference> defaultAuth()
	{
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfo("E-Medplus pharma REST API WITH SWAGGER", "Medicine Shop management system", 
				"1.1", "Terms of service", new Contact("E-medplus pharma", "www.e-medplus pharma.org", "runner@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}
	
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apikey())).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
}
