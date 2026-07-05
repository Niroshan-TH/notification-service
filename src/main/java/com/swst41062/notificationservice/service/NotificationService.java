package com.swst41062.notificationservice.service;

import com.swst41062.notificationservice.dto.OrderEventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    public void sendNotification(OrderEventMessage event) {
        log.info("Notification -> customerId={}, orderId={}, timestamp={}, message='{}'",
                event.getCustomerId(), event.getOrderId(), event.getTimestamp(), event.getMessage());
    }
}
