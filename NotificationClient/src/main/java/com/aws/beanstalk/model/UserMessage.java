package com.aws.beanstalk.model;


import javax.persistence.*;
import java.math.BigInteger;
@Entity
@Table(name = "user_message")
public class UserMessage {
        @Id
        @Column(name="user")
        private String user;
        @Column(name="message")
        private String message;
        public UserMessage(){};

        public UserMessage(String user, String message) {
                this.user = user;
                this.message = message;
        }

        public String getUser() {
                return user;
        }

        public void setUser(String user) {
                this.user = user;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }
}
