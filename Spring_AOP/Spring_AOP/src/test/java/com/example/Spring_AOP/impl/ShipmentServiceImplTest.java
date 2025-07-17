package com.example.Spring_AOP.impl;

import com.example.Spring_AOP.services.impl.ShipmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ShipmentServiceImplTest {

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @Test
    void aopTestOrderPackage() {
        String orderString = shipmentService.orderPackage(4L);
        log.info(orderString);
    }

    @Test
    void aopTestTrackPackage() {
        shipmentService.trackPackage(4L);
    }

}