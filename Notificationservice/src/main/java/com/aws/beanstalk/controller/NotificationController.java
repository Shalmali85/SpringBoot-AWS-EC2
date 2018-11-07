package com.aws.beanstalk.controller;

import com.aws.beanstalk.entity.Notify;
import com.aws.beanstalk.model.Notification;
import com.aws.beanstalk.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @RequestMapping(value="/notify/{user}",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notify> getUserNotificationDetails(@PathVariable("user")String user){
        Notify notificationEntityList =  notificationService.getUserSubscription(user);
        return new ResponseEntity<>(notificationEntityList, HttpStatus.OK);
    }
    @RequestMapping(value="/notify/all",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notify>> getAllNotificationDetails(){
        List<Notify> notificationEntityList =  notificationService.getAllSubscription();
        return new ResponseEntity<>(notificationEntityList, HttpStatus.OK);
    }

    @RequestMapping(value="/notify",
            method=RequestMethod.POST)
    public ResponseEntity subscribeUser(@RequestBody Notify notification){
        notificationService.saveSubscription(notification);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value="/notify",
            method=RequestMethod.DELETE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeSubscription(@RequestBody Notify notification){
        notificationService.removeSubscription(notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
