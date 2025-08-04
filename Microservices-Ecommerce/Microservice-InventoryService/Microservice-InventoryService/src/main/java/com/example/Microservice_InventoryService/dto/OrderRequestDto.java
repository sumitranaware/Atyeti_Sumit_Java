package com.example.Microservice_InventoryService.dto;

import lombok.Data;
import org.hibernate.query.Order;

import java.util.List;
@Data
public class OrderRequestDto {
    private List<OrderRequestItemDto>items;

}
