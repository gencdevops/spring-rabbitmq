package com.example.springrabbitmq.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {

    private String notificationId;

    private Date notificationCreatedDate;

    private Boolean seen;

    private String message;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public Date getNotificationCreatedDate() {
        return notificationCreatedDate;
    }

    public void setNotificationCreatedDate(Date notificationCreatedDate) {
        this.notificationCreatedDate = notificationCreatedDate;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
