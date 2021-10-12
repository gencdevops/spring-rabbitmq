package com.example.springrabbitmq.producer;

import com.example.springrabbitmq.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {
    @Value("${spring-rabbit-routing}")
    private String routingName;

    @Value("${spring-rabbit-exchange}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sentToQueue(Notification notification) {
        System.out.println("Notification Sent ID: " + notification.getNotificationId());
    rabbitTemplate.convertAndSend(exchangeName,routingName, notification);
    }

    @PostConstruct
    public void initialize() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setNotificationCreatedDate(new Date());
        notification.setMessage("RabbitMq message is sending");
        notification.setSeen(Boolean.FALSE);

        sentToQueue(notification);
    }
}
