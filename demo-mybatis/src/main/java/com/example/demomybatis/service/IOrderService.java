package com.example.demomybatis.service;

import com.example.demomybatis.entity.Order;

/**
 * desc:
 *
 * @author zhang
 * @date 2022/4/1 14:26
 */
public interface IOrderService {

    Integer saveOrder(Order order);
}
