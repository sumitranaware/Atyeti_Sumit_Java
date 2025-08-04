package com.example.Microservice_InventoryService.controller;

import com.example.Microservice_InventoryService.clients.OrdersFeignClient;
import com.example.Microservice_InventoryService.dto.OrderRequestDto;
import com.example.Microservice_InventoryService.dto.ProductDTO;
import com.example.Microservice_InventoryService.entity.Product;
import com.example.Microservice_InventoryService.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;
    private final OrdersFeignClient ordersFeignClient;
    @GetMapping("/fetchOrders")
    public String fetchOrdersService() {
        ServiceInstance orderService = discoveryClient.getInstances("Microservice-OrderService").get(0);
        String url = orderService.getUri() + "/orders/core/helloOrders";
        log.info("Calling URL: {}", url);
//
//        return restClient.get()
//                .uri(url)
//                .retrieve()
//                .body(String.class);

        return ordersFeignClient.helloOrders();
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>>getAllInventory(){
        List<ProductDTO>inventories=productService.getAllInventory();
        return ResponseEntity.ok(inventories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO>getInventoryById(@PathVariable Long id){
        ProductDTO inventory=productService.getProductById(id);
        return ResponseEntity.ok(inventory);
    }
    @PutMapping("reduce-stocks")
     public ResponseEntity<Double>reduceStocks(@RequestBody OrderRequestDto orderRequestDto){
        Double totalPrice =productService.reduceStocks(orderRequestDto);
        return ResponseEntity.ok(totalPrice);
    }
}
