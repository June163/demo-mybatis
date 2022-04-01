package com.example.demomybatis.service.impl;

import com.example.demomybatis.entity.Order;
import com.example.demomybatis.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    IOrderService orderService;

    @Test
    void saveOrder() {
        Integer integer = orderService.saveOrder(Order.builder().name("事务")
                .num(1)
                .build());
        System.out.println("条数："+integer);
    }
}