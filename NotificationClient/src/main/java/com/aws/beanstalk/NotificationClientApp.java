package com.aws.beanstalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@EnableContextCredentials(accessKey = "*", secretKey ="*" )
@EnableContextRegion(region = "*")
@EnableJpaRepositories(basePackages="com.aws.beanstalk.repo")
@ImportAutoConfiguration(FeignAutoConfiguration.class)
@EntityScan(basePackages="com.aws.beanstalk.model")
@ComponentScan(basePackages="com.aws.beanstalk")
public class NotificationClientApp {
    @RequestMapping("/ping")
    public String test() {
        return "testing client";
    }
    public static void main(String[] args) {
        SpringApplication.run(NotificationClientApp.class, args);
    }
}
