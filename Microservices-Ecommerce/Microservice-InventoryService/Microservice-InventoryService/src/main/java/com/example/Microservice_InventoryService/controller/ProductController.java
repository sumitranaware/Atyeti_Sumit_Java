package com.example.Microservice_InventoryService.controller;

import com.example.Microservice_InventoryService.dto.ProductDTO;
import com.example.Microservice_InventoryService.entity.Product;
import com.example.Microservice_InventoryService.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

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
}
