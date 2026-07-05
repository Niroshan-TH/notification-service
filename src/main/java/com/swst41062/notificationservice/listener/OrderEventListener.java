package com.swst41062.notificationservice.listener;

import com.swst41062.notificationservice.dto.OrderEventMessage;
import com.swst41062.notificationservice.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    private final NotificationService notificationService;

    public OrderEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${messaging.order-events.queue}")
    public void handleOrderCreated(OrderEventMessage event) {
        notificationService.sendNotification(event);
    }
}
