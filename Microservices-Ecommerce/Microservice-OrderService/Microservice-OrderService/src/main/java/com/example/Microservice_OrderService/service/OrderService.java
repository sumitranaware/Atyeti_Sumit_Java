package com.example.Microservice_OrderService.service;

import com.example.Microservice_OrderService.clients.InventoryOpenFeignClient;
import com.example.Microservice_OrderService.dto.OrderRequestDTO;
import com.example.Microservice_OrderService.entity.OrderItem;
import com.example.Microservice_OrderService.entity.OrderStatus;
import com.example.Microservice_OrderService.entity.Orders;
import com.example.Microservice_OrderService.repository.OrderRespository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRespository orderRespository;
    private final ModelMapper modelMapper;
    private final InventoryOpenFeignClient inventoryOpenFeignClient;

    public List<OrderRequestDTO>getAllOrders(){
        log.info("Fetching all orders");
      List<Orders>orders=orderRespository.findAll();
      return orders.stream().map(order->modelMapper.map(order, OrderRequestDTO.class))
              .toList();
    }

    public OrderRequestDTO getOrderById(Long id){
        log.info("Fetching order with id",id);
        Orders order=orderRespository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
        return modelMapper.map(order,OrderRequestDTO.class);

    }

   // @Retry(name = "inventoryRetry", fallbackMethod = "createOrderFallback")
    @CircuitBreaker(name ="inventoryCircuitBreaker",fallbackMethod = "createOrderFallback")
    @RateLimiter(name="inventoryRateLimiter",fallbackMethod = "createOrderFallback")
    public OrderRequestDTO createOrder(OrderRequestDTO orderRequestDTO) {
       Double totalPrice=inventoryOpenFeignClient.reduceStocks(orderRequestDTO);

       Orders orders = modelMapper.map(orderRequestDTO , Orders.class);
       for (OrderItem orderItem:orders.getItems()){
           orderItem.setOrder(orders);

       }

       orders.setPrice(totalPrice);
       orders.setOrderStatus(OrderStatus.CONFIRMED);

       Orders saveOrder = orderRespository.save(orders);
       return modelMapper.map(saveOrder,OrderRequestDTO.class);
    }
    public OrderRequestDTO createOrderFallback(OrderRequestDTO orderRequestDTO,Throwable throwable) {
      log.error("FallBack occurred due to :{}",throwable.getMessage());

      return new OrderRequestDTO();
    }
}
