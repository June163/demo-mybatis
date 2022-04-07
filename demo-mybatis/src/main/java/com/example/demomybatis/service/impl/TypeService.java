package com.example.demomybatis.service.impl;

import org.springframework.stereotype.Service;

/**
 * desc: 类型区分
 *
 * @author zhang
 * @date 2022/4/7 15:34
 */

@Service
public class TypeService {


    /**
     * desc: 银行卡类型
     * @param type
     * @return
     */
    public String bankType(String type){
        return "付款类型银行卡："+type;
    }

    /**
     * desc: 现金付款类型
     * @param type
     * @return
     */
    public String cashType(String type){
        return "现金付款类型："+type;
    }
    /**
     * desc: 微信付款类型
     * @param type
     * @return
     */
    public String weChatType(String type){
        return "微信付款类型："+type;
    }
    /**
     * desc: 支付宝付款类型
     * @param type
     * @return
     */
    public String paidType(String type){
        return "支付宝付款类型"+type;
    }



}
