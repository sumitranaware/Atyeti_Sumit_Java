package com.example.Microservice_InventoryService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "MICROSERVICE-ORDERSERVICE",path ="/orders")
public interface OrdersFeignClient {

    @GetMapping("/core/helloOrders")
     String helloOrders();

}
