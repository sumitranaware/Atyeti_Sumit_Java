package com.example.Microservice_OrderService.service;

import com.example.Microservice_OrderService.dto.OrderRequestDTO;
import com.example.Microservice_OrderService.entity.Orders;
import com.example.Microservice_OrderService.repository.OrderRespository;
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
}
