package com.javainuse;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/validateUser")
	public Principal user(Principal user) {
		return user;
	}

	@RequestMapping("/test/all")
	public String test() {
		return "Success";
	}
	@RequestMapping("/test/user")
	public String user() {
		return "{'user':'riya'}";
	}

	@RequestMapping("/ping")
	public String ping() {
		return "Success";
	}
	@RequestMapping("/ping/test")
	public String sucess() {
		return "Success";
	}
}
