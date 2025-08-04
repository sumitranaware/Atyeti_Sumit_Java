package com.example.Microservice_InventoryService.service;

import com.example.Microservice_InventoryService.dto.OrderRequestDto;
import com.example.Microservice_InventoryService.dto.OrderRequestItemDto;
import com.example.Microservice_InventoryService.dto.ProductDTO;
import com.example.Microservice_InventoryService.entity.Product;
import com.example.Microservice_InventoryService.repository.ProductRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Double reduceStocks(OrderRequestDto orderRequestDto) {
        log.info("Reducing the stocks ");
        Double totalPrice=0.0;
        for (OrderRequestItemDto orderRequestItemDto:orderRequestDto.getItems()) {
        Long productId=orderRequestItemDto.getProductId();
        Integer quantity=orderRequestItemDto.getQuantity();

        Product product =productRepository.findById(productId).orElseThrow(()->
                new RuntimeException("Product not found with id "+productId)
                );
        if (product.getStocks()<quantity){
            throw  new RuntimeException("Product cannot be fullfilled for given quantity");
        }
        product.setStocks(product.getStocks()-quantity);
        productRepository.save(product);
        totalPrice+=quantity*product.getPrice();

        }
        return totalPrice;
    }
}
