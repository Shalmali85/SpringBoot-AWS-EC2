package com.aws.beanstalk.service;

import com.aws.beanstalk.entity.Notify;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("NOTIFICATIONSERVICE")

public interface INotificationClient {
    @RequestMapping(value = "/notify/{user}", method = GET)
    Notify getUserNotificationDetails(@PathVariable("user")String user);

}
