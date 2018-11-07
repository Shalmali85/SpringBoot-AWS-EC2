package com.aws.beanstalk.model;


import javax.persistence.*;
import java.math.BigInteger;
@Entity
@Table(name = "notification")
public class Notification {
        @Id
        @Column(name="endpoint")
        private String endpoint;
        @Column(name="auth_keys")
        private String keys ;
        @Column(name="user")
        private String user;
        @Column(name="count")
        private int count=0;
        @Column(name="lastDeliveredTime")
        private Long lastDeliveredTime = Long.valueOf(System.currentTimeMillis());

        public Notification(){};

        public Notification(String endpoint, String keys, String user, int count, Long lastDeliveredTime) {
                this.endpoint = endpoint;
                this.keys = keys;
                this.user = user;
                this.count = count;
                this.lastDeliveredTime = lastDeliveredTime;
        }

        public String getEndpoint() {
                return endpoint;
        }

        public void setEndpoint(String endpoint) {
                this.endpoint = endpoint;
        }

        public String getKeys() {
                return keys;
        }

        public void setKeys(String keys) {
                this.keys = keys;
        }

        public String getUser() {
                return user;
        }

        public void setUser(String user) {
                this.user = user;
        }

        public int getCount() {
                return count;
        }

        public void setCount(int count) {
                this.count = count;
        }

        public Long getLastDeliveredTime() {
                return lastDeliveredTime;
        }

        public void setLastDeliveredTime(Long lastDeliveredTime) {
                this.lastDeliveredTime = lastDeliveredTime;
        }
}
