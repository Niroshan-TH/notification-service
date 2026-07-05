package com.swst41062.notificationservice.listener;

import com.swst41062.notificationservice.dto.OrderEventMessage;
import com.swst41062.notificationservice.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderEventListenerTest {

    @Mock
    private NotificationService notificationService;

    @Test
    void handleOrderCreated_delegatesToNotificationService() {
        OrderEventListener listener = new OrderEventListener(notificationService);
        OrderEventMessage event = new OrderEventMessage(1L, 100L, Instant.now(), "Order 1 created for customer 100");

        listener.handleOrderCreated(event);

        ArgumentCaptor<OrderEventMessage> captor = ArgumentCaptor.forClass(OrderEventMessage.class);
        verify(notificationService).sendNotification(captor.capture());
        assertThat(captor.getValue().getOrderId()).isEqualTo(1L);
        assertThat(captor.getValue().getCustomerId()).isEqualTo(100L);
    }
}
