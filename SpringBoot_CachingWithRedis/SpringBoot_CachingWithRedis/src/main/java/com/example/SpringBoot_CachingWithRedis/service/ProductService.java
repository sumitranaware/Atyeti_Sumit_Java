package com.example.SpringBoot_CachingWithRedis.service;

import com.example.SpringBoot_CachingWithRedis.model.Product;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService  {
    private final ConcurrentHashMap<String,Product>database=new ConcurrentHashMap<>();

    @Cacheable(value = "productCache",key="allProducts")
    public List<Product>getAllProduct(){
        //simualtesSlowCall();
        return new ArrayList<>(database.values());
    }
    @Cacheable(value = "productCache",key="#productId")
    public Product getProductById(String productId){
        simualtesSlowCall();
        return new Product(productId,"product-"+productId);
    }
    @CacheEvict(value = "productCache",key="#product.id")
    public Product addProduct(Product product){
        database.put(product.getId(),product);
        return product;
    }

    private void simualtesSlowCall(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException ignored){

        }
    }
}
