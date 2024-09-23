package com.meiggsmarket.orderservice.controller;

import com.meiggsmarket.orderservice.dto.OrderRequest;
import com.meiggsmarket.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController  // Marca la clase como un controlador de Spring que gestiona las solicitudes HTTP.
@RequestMapping("/api/order")  // Define el endpoint base para todas las solicitudes relacionadas con pedidos.
@RequiredArgsConstructor  // Genera un constructor con todos los campos 'final', lo que facilita la inyección de dependencias.
public class OrderController {

    private final OrderService orderService;  // Inyección del servicio de pedidos para manejar la lógica empresarial.

    @PostMapping  // Maneja solicitudes HTTP POST en el endpoint "/api/order".
    @ResponseStatus(HttpStatus.CREATED)  // Devuelve el código de estado HTTP 201 (CREATED) cuando la solicitud se procesa correctamente.
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        // El cuerpo de la solicitud se mapea a un objeto OrderRequest y se pasa al servicio de pedidos.
        orderService.placeOrder(orderRequest);
        // Devuelve una respuesta indicando que el pedido se realizó con éxito.
        return "Order Placed Successfully";
    }
}
