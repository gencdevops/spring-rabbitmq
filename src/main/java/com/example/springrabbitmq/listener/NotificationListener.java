package com.example.springrabbitmq.listener;

import com.example.springrabbitmq.model.Notification;

public class NotificationListener {

    public void handleMessage(Notification notification) {
        System.out.println(notification.toString());
}

}
