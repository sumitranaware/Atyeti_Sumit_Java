package com.example.SpringBoot_CachingWithRedis.controller;

import com.example.SpringBoot_CachingWithRedis.model.Product;
import com.example.SpringBoot_CachingWithRedis.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProductById(id);
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

}

