package com.example.Microservice_InventoryService.repository;

import com.example.Microservice_InventoryService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product ,Long> {

}
