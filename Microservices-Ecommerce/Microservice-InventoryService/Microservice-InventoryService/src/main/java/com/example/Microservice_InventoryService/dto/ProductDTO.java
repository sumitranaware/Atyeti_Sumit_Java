package com.example.Microservice_InventoryService.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;

    private String title;
    private Double price;

    private Integer stocks;
}
