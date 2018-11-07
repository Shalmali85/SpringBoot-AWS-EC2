package com.aws.beanstalk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableContextCredentials(accessKey = "*", secretKey ="*" )
@EnableContextRegion(region = "*")
@EnableEurekaServer
public class Eureka {


	public static void main(String[] args) {
		SpringApplication.run(Eureka.class, args);
	}

}
