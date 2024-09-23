package com.meiggsmarket.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data  // Genera automáticamente getters, setters, toString, equals y hashCode.
@AllArgsConstructor  // Genera un constructor con todos los campos como parámetros.
@NoArgsConstructor  // Genera un constructor sin parámetros.
public class OrderRequest {
    // Lista de ítems del pedido, cada ítem está representado por un objeto OrderLineItemsDto.
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
