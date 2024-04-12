package com.rishmi5h.microservices.order.service;


import com.rishmi5h.microservices.order.dto.OrderLineItemsDto;
import com.rishmi5h.microservices.order.dto.OrderRequest;
import com.rishmi5h.microservices.order.model.Order;
import com.rishmi5h.microservices.order.model.OrderLineItems;
import com.rishmi5h.microservices.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        orderRequest.orderLineItemsDtoList()
                .stream()
                .map(this::map)
                .forEach(order::addOrderLineItems);
        orderRepository.save(order);
    }

    private OrderLineItems map(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.price());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }
}
