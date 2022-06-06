package com.examples.axon.aggregates;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.examples.axon.commands.ConfirmOrderCommand;
import com.examples.axon.commands.CreateOrderCommand;
import com.examples.axon.commands.ShipOrderCommand;
import com.examples.axon.events.OrderConfirmedEvent;
import com.examples.axon.events.OrderCreatedEvent;
import com.examples.axon.events.OrderShippedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private boolean orderConfirmed;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        apply(new OrderCreatedEvent(command.getOrderId(), command.getProductId()));
    }

    @CommandHandler
    public void handle(ConfirmOrderCommand command) {
        if (orderConfirmed) {
            return;
        }
        apply(new OrderConfirmedEvent(orderId));
    }

    @CommandHandler
    public void handle(ShipOrderCommand command) {
        if (!orderConfirmed) {
            throw new RuntimeException("unconfirmed order");
        }
        apply(new OrderShippedEvent(orderId));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        orderConfirmed = false;
    }

    @EventSourcingHandler
    public void on(OrderConfirmedEvent event) {
        orderConfirmed = true;
    }
}
