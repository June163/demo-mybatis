package com.example.demomybatis.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QueryTypeServiceTest {

    @Autowired
    QueryTypeService queryTypeService;

    @Test
    void getRealType() {
        System.out.println(queryTypeService.getRealType("1"));
        System.out.println(queryTypeService.getRealType("2"));
        System.out.println(queryTypeService.getRealType("3"));
        System.out.println(queryTypeService.getRealType("4"));
    }
}