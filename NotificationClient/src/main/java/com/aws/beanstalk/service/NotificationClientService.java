package com.aws.beanstalk.service;

import com.aws.beanstalk.entity.Notify;


import com.aws.beanstalk.model.UserMessage;
import com.aws.beanstalk.repo.UserMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationClientService {


 @Autowired
 UserMessageRepo userMessageRepo;

 @Autowired
 INotificationClient notificationClient;


    public Notify getUserMessage(String user) throws Exception {
        UserMessage userMessage= userMessageRepo.findByUser(user);
        if(userMessage!= null) {
            Notify notifyService = notificationClient.getUserNotificationDetails(user);
            notifyService.setMessage(userMessage.getMessage());
            return notifyService;
        }
        throw(new Exception("User does not  exist"));
    }
    public List<Notify> getAllMessages(){
        List<UserMessage> notificationList= userMessageRepo.findAll();
        List<Notify> notifyList = new ArrayList<>();
        if(notificationList!= null) {
            notificationList.forEach(notify->{
                Notify notifyService = notificationClient.getUserNotificationDetails(notify.getUser());
                notifyService.setMessage(notify.getMessage());
                notifyList.add(notifyService);

            });
        }

        return notifyList;
    }
    @Transactional
    public void saveMessage(UserMessage userMessage){
        UserMessage saveUserMessage= userMessageRepo.findByUser(userMessage.getUser());
        if(saveUserMessage == null) {
            userMessageRepo.save(userMessage);
        }
    }
   }
