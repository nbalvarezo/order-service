package com.meiggsmarket.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data  // Genera automáticamente los métodos getters, setters, toString, equals y hashCode.
@AllArgsConstructor  // Genera un constructor con todos los campos de la clase como parámetros.
@NoArgsConstructor  // Genera un constructor vacío (sin parámetros).
public class OrderLineItemsDto {
    private Long id;  // Identificador único del ítem de la línea del pedido.
    private String skuCode;  // Código SKU (Stock Keeping Unit), que identifica el producto.
    private BigDecimal price;  // Precio del ítem.
    private Integer quantity;  // Cantidad de ítems solicitados.
}
