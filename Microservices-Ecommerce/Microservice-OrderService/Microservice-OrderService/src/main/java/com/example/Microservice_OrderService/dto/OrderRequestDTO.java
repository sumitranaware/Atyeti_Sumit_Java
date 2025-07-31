package com.example.Microservice_OrderService.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderRequestDTO {
    private Long id;
    private List<OrderRequestItemDTO>items;
    private BigDecimal totalPrice;

}
