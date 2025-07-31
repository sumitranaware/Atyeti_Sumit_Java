package com.example.Microservice_OrderService.dto;

import lombok.Data;

@Data
public class OrderRequestItemDTO {
    private Long id;
    private Long productId;
    private Long quantity;
}
