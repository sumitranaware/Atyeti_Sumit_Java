package com.example.Microservice_InventoryService.service;

import com.example.Microservice_InventoryService.dto.ProductDTO;
import com.example.Microservice_InventoryService.entity.Product;
import com.example.Microservice_InventoryService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductDTO>getAllInventory(){
        log.info("Fetching all inventory items ");
        List<Product>inventories=productRepository.findAll();
        return inventories.stream()
                .map(product -> modelMapper.map(product,ProductDTO.class))
                .toList();
    }

    public ProductDTO getProductById(Long id){
        log.info("Fetching product with id",id);
        Optional<Product>inventory=productRepository.findById(id);
        return inventory.map(item->modelMapper.map(item,ProductDTO.class))
                .orElseThrow(()->new RuntimeException("Inventory not  found"));
    }
}
