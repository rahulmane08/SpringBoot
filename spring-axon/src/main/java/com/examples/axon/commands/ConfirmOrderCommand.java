package com.examples.axon.commands;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@EqualsAndHashCode
@ToString
@Data
public class ConfirmOrderCommand {
    @TargetAggregateIdentifier
    private final String orderId;
}
