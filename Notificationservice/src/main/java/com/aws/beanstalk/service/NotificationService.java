package com.aws.beanstalk.service;

import com.aws.beanstalk.entity.Notify;
import com.aws.beanstalk.mapper.NotifyMapper;
import com.aws.beanstalk.model.Notification;
import com.aws.beanstalk.repo.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NotificationService {


 @Autowired
    NotificationRepo notificationRepo;


    public Notify getUserSubscription(String user){
        Page<Notification> notificationList= notificationRepo.findByUser(user,new PageRequest(0,1));
        NotifyMapper notifyMapper = new NotifyMapper();
        Notify notify =notifyMapper.covertToJson(notificationList.getContent().get(0));
        return notify;
    }
    public List<Notify> getAllSubscription(){
        List<Notification> notificationList= notificationRepo.findAll();
        System.out.println("testing----");
        NotifyMapper notifyMapper = new NotifyMapper();
        List<Notify> notifyList =notifyMapper.covertToJsonList(notificationList);

        return notifyList;
    }
    @Transactional
    public void saveSubscription(Notify notify){
        Notification notificationSubscriber= notificationRepo.findBySubscribedEndpoint(notify.getEndpoint());
        if(notificationSubscriber == null) {
            NotifyMapper notifyMapper = new NotifyMapper();
            Notification notification = notifyMapper.covertFromJson(notify);
            notificationRepo.save(notification);
        }
    }
    @Transactional
    public void removeSubscription(Notify notification){
        Notification notificationSubscriber= notificationRepo.findBySubscribedEndpoint(notification.getEndpoint());
        if(notificationSubscriber != null) {
            notificationRepo.delete(notificationSubscriber);
        }
    }}
