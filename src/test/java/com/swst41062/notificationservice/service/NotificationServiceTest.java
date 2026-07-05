package com.swst41062.notificationservice.service;

import com.swst41062.notificationservice.dto.OrderEventMessage;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThatCode;

class NotificationServiceTest {

    @Test
    void sendNotification_logsWithoutThrowing() {
        NotificationService notificationService = new NotificationService();
        OrderEventMessage event = new OrderEventMessage(1L, 100L, Instant.now(), "Order 1 created for customer 100");

        assertThatCode(() -> notificationService.sendNotification(event)).doesNotThrowAnyException();
    }
}
