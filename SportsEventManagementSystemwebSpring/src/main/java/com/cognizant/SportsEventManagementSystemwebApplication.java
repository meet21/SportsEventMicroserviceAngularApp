package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cognizant.Model.Users;
import com.cognizant.Repository.RegistrationRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import jakarta.annotation.PostConstruct;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SportsEventManagementSystemwebApplication {
	
	@Autowired
    private RegistrationRepository repository;

    @PostConstruct
    public void initUsers() {
        List<Users> users = Stream.of(
                new Users(101, "javatechie@gmail.com", "Meet", "password"),
                new Users(102, "user1@gmail.com", "user1", "pwd1"),
                new Users(103,  "user2@gmail.com","user2", "pwd2"),
                new Users(104,  "user3@gmail.com","user3", "pwd3")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

	public static void main(String[] args) {
		SpringApplication.run(SportsEventManagementSystemwebApplication.class, args);
	}
	
	@Bean
	Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant.SportsEventManagementSystemwebSpring"))
				.build()
				.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SportsEventManagementSystemwebSpring JWT Auth API")
				.description("This API can be used to make JWT Authentication between other MS")
				.version("V1.0")
				.build();
	}

}
