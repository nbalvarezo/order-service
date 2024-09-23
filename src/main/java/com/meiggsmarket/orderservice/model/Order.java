package com.meiggsmarket.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity  // Marca la clase como una entidad de JPA que mapea una tabla en la base de datos.
@Table(name = "orders")  // Especifica que esta entidad se mapeará a la tabla "orders".
@Getter  // Genera automáticamente los métodos getter para todos los campos.
@Setter  // Genera automáticamente los métodos setter para todos los campos.
@NoArgsConstructor  // Genera un constructor sin argumentos.
@AllArgsConstructor  // Genera un constructor con todos los campos como parámetros.
public class Order {

    @Id  // Define el campo 'id' como la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.AUTO)  // Especifica la estrategia de generación automática de IDs.
    private Long id;

    private String orderNumber;  // Campo que almacena el número del pedido.

    @OneToMany(cascade = CascadeType.ALL)  // Define una relación de uno a muchos con la entidad 'OrderLineItems'.
    private List<OrderLineItems> orderLineItemsList;  // Lista de ítems de la orden.
}
