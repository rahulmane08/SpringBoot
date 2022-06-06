package com.examples.axon.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Data
public class OrderConfirmedEvent {
    private final String orderId;
}
