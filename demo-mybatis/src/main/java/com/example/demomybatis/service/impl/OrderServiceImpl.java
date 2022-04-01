package com.example.demomybatis.service.impl;

import com.example.demomybatis.dao.OrderMapper;
import com.example.demomybatis.entity.Order;
import com.example.demomybatis.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * desc:
 *
 * @author zhang
 * @date 2022/4/1 14:26
 */
@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    OrderMapper orderMapper;


    @Override
    public Integer saveOrder(Order order) {
        return orderMapper.insert(order);
    }
}
