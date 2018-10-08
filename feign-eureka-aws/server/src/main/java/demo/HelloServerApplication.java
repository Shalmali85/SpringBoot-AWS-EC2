package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaServer
@RestController
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
