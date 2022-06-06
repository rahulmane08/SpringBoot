package com.examples.axon.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Data
public class OrderShippedEvent {
    private final String orderId;
}
