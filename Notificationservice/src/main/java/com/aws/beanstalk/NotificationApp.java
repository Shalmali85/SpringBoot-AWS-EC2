package com.aws.beanstalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
@EnableContextCredentials(accessKey = "*", secretKey ="*" )
@EnableContextRegion(region = "*")
@EnableJpaRepositories(basePackages="com.aws.beanstalk.repo")
@EntityScan(basePackages="com.aws.beanstalk.model")
@ComponentScan(basePackages="com.aws.beanstalk")
public class NotificationApp {
    @RequestMapping("/ping")
    public String test() {
        return "testing";
    }
    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class, args);
    }
}
