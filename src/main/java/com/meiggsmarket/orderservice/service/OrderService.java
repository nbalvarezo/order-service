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

@Service  // Marca la clase como un servicio de Spring, indicando que contiene la lógica de negocio.
@RequiredArgsConstructor  // Genera un constructor para inyectar las dependencias requeridas.
public class OrderService {

    private final OrderRepository orderRepository;  // Inyección del repositorio de órdenes para acceder a la base de datos.

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        // Genera un número de orden único usando UUID.
        order.setOrderNumber(UUID.randomUUID().toString());

        // Mapea los ítems de la solicitud a entidades de línea de pedido.
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToEntity)  // Cambiado a mapToEntity para mayor claridad.
                .toList();

        // Establece la lista de ítems de línea de pedido en la entidad de orden.
        order.setOrderLineItemsList(orderLineItems);

        // Guarda la nueva orden en la base de datos.
        orderRepository.save(order);
    }

    private OrderLineItems mapToEntity(OrderLineItemsDto orderLineItemsDto) {
        // Crea una nueva instancia de OrderLineItems y establece sus propiedades.
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;  // Devuelve la entidad mapeada.
    }
}
