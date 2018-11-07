package com.aws.beanstalk.repo;

import com.aws.beanstalk.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification,Integer> {
    @Query(" Select new com.aws.beanstalk.model.Notification(n.endpoint ,n.keys ,n.user ,n.count, n.lastDeliveredTime)  from Notification  n where n.user = :user order by n.lastDeliveredTime desc ")
    Page<Notification> findByUser(@Param("user")String user, Pageable pageable);
    @Query("Select new com.aws.beanstalk.model.Notification(n.endpoint ,n.keys ,n.user ,n.count, n.lastDeliveredTime)  from Notification n where n.endpoint = ?")
    Notification findBySubscribedEndpoint(@Param("endpoint")String endpoint);
    /*@Modifying
    @Query("DELETE from Notification")
    void deleteSubscription();*/
}
