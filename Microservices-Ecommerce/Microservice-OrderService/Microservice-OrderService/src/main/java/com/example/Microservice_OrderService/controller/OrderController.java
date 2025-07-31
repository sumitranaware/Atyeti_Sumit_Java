package com.example.Microservice_OrderService.controller;

import com.example.Microservice_OrderService.dto.OrderRequestDTO;
import com.example.Microservice_OrderService.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderRequestDTO>>getAllOrders(HttpServletRequest httpServletRequest){
        log.info("Fetching all orders via controller");
        List<OrderRequestDTO>orders=orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDTO>getAllOrderId(@PathVariable Long id){
        log.info("Fetching order with id",id);
        OrderRequestDTO order=orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
}
