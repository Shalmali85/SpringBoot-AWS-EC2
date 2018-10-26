package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaServer
@RestController
@EnableContextCredentials(accessKey = "*", secretKey ="*" )
@EnableContextRegion(region = "*")
public class HelloServerApplication {


	@RequestMapping("/test")
	public String hello() {
		return "Hello World:";
	}

	@RequestMapping("/ping")
	public String test() {
		return "testing";
	}
	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
	}
}
