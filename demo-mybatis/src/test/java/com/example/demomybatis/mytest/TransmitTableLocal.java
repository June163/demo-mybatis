package com.example.demomybatis.mytest;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

/**
 * desc:
 *
 * @author zhang
 * @date 2022/4/7 10:37
 */
public class TransmitTableLocal {
    public static void main(String[] args) {
        TtlExecutors.getDefaultDisableInheritableThreadFactory();
    }
}
