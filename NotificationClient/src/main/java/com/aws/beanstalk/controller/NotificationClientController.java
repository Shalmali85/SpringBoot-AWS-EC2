package com.aws.beanstalk.controller;

import com.aws.beanstalk.entity.Notify;
import com.aws.beanstalk.model.UserMessage;
import com.aws.beanstalk.service.NotificationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class NotificationClientController {
    @Autowired
    NotificationClientService notificationClientService;

    @RequestMapping(value="/notify/{user}/message",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notify> getUserNotificationMeassge(@PathVariable("user")String user) throws Exception {
        Notify notificationEntityList =  notificationClientService.getUserMessage(user);
        return new ResponseEntity<>(notificationEntityList, HttpStatus.OK);
    }
    @RequestMapping(value="/notify/all/messages",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notify>> getAllNotificationMessages(){
        List<Notify> notificationEntityList =  notificationClientService.getAllMessages();
        return new ResponseEntity<>(notificationEntityList, HttpStatus.OK);
    }

    @RequestMapping(value="/message",
            method=RequestMethod.POST)
    public ResponseEntity subscribeUser(@RequestBody UserMessage userMessage){
        notificationClientService.saveMessage(userMessage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
