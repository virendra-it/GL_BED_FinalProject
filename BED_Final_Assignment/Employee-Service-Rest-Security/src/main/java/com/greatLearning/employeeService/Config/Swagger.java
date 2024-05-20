package com.greatLearning.employeeService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
	@Bean
	public Docket employeeApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.groupName("Employee_Api")
				.select().apis(RequestHandlerSelectors.basePackage("com.greatLearning.employeeService.controller"))
				.build();
		
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new  ApiInfoBuilder().title("Employee Api")
				.description("Employee Management Api")
				.termsOfServiceUrl("http://glEmployeeManagementApi.com")
				.contact(new Contact("Employee Management Api", "http://glEmployeeManagementApi.com", "employeeapi@gl.com"))
				.license("Employee Api License")
				.licenseUrl("http://glEmployeeManagementApi.com")
				.version("1.0")
				.build();
	}
		
	

}
