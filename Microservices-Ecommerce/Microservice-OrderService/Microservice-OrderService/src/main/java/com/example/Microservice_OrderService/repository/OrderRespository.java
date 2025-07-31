package com.example.Microservice_OrderService.repository;

import com.example.Microservice_OrderService.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRespository extends JpaRepository<Orders,Long> {
}
