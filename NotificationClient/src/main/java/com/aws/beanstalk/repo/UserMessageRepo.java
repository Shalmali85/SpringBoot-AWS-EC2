package com.aws.beanstalk.repo;

import com.aws.beanstalk.model.UserMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMessageRepo extends JpaRepository<UserMessage,Integer> {
    @Query(" Select new com.aws.beanstalk.model.UserMessage(u.user ,u.message)  from UserMessage  u where u.user = :user")
    UserMessage findByUser(@Param("user")String user);
}
