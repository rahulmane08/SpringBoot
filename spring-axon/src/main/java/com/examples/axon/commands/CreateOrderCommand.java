package com.examples.axon.commands;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@EqualsAndHashCode
@ToString
@Data
public class CreateOrderCommand {
    @TargetAggregateIdentifier
    private final String orderId;
    private final String productId;
}
