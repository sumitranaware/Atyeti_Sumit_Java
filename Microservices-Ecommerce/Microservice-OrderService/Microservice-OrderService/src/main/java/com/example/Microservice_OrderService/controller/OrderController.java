package com.example.Microservice_OrderService.controller;

import com.example.Microservice_OrderService.clients.InventoryOpenFeignClient;
import com.example.Microservice_OrderService.dto.OrderRequestDTO;
import com.example.Microservice_OrderService.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
private final OrderService orderService;
private final InventoryOpenFeignClient inventoryOpenFeignClient;

@GetMapping("/helloOrders")
public String helloOrders(){
    return "hello from orders Service";
}

    @PostMapping("/create-order")
  public ResponseEntity<OrderRequestDTO>createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
    OrderRequestDTO orderRequestDTO1=orderService.createOrder(orderRequestDTO);
    return ResponseEntity.ok(orderRequestDTO1);

    }
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
