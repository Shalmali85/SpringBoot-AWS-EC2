package com.aws.beanstalk.mapper;

import com.aws.beanstalk.entity.Notify;
import com.aws.beanstalk.model.Notification;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class NotifyMapper {


    public Notify covertToJson(Notification notification){
        Notify notify = new Notify();
        notify.setEndpoint(notification.getEndpoint());
        notify.setCount(notification.getCount());
        notify.setTime(notification.getLastDeliveredTime());
        notify.setUser(notification.getUser());
        Gson gson = new Gson();
        Notify.Keys keys = gson.fromJson(notification.getKeys(),Notify.Keys.class);
        notify.setKeys(keys);
        return notify;
    }

    public List<Notify> covertToJsonList(List<Notification> notificationList){
        List<Notify> notifyList = new ArrayList<>();
        notificationList.forEach(notification -> {
        Notify notify = new Notify();
        notify.setEndpoint(notification.getEndpoint());
        notify.setCount(notification.getCount());
        notify.setTime(notification.getLastDeliveredTime());
        notify.setUser(notification.getUser());
        Gson gson = new Gson();
        Notify.Keys keys = gson.fromJson(notification.getKeys(),Notify.Keys.class);
        notify.setKeys(keys);
        notifyList.add(notify);
        });
        return notifyList;
    }

    public Notification covertFromJson(Notify notify){
        Notification notification = new Notification();
        notification.setEndpoint(notify.getEndpoint());
        notification.setCount(notify.getCount());
        notification.setLastDeliveredTime(notify.getTime());
        notification.setUser(notify.getUser());
        Gson gson = new Gson();
        String keys = gson.toJson(notify.getKeys());
        notification.setKeys(keys);
        return notification;
    }
}
