package com.meiggsmarket.orderservice.service;

import com.meiggsmarket.orderservice.dto.OrderLineItemsDto;
import com.meiggsmarket.orderservice.dto.OrderRequest;
import com.meiggsmarket.orderservice.model.Order;
import com.meiggsmarket.orderservice.model.OrderLineItems;
import com.meiggsmarket.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto).toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        new OrderLineItems();
        orderLineItemsDto.setPrice(orderLineItemsDto.getPrice());
        orderLineItemsDto.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItemsDto.setSkuCode(orderLineItemsDto.getSkuCode());
        return null;
    }
}
