package com.examples.axon.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Data
public class OrderCreatedEvent {
    private final String orderId;
    private final String productId;
}
