package com.example.demomybatis.service.impl;

import com.example.demomybatis.dao.OrderMapper;
import com.example.demomybatis.entity.Order;
import com.example.demomybatis.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * desc:
 *
 * @author zhang
 * @date 2022/4/1 14:26
 */
@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired(required = false)
    OrderMapper orderMapper;


    @Autowired
    TransactionTemplate transactionTemplate ;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveOrder(Order order) {

        transactionTemplate.execute(
                new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus status) {
                        orderMapper.insert(order);
                        int i = 1/0 ;
                    }
                }
        );


        return null;
    }
}
