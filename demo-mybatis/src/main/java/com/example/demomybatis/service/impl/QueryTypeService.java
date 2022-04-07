package com.example.demomybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * desc:
 *
 * @author zhang
 * @date 2022/4/7 15:34
 */
@Service
public class QueryTypeService {

    @Autowired
    private TypeService typeService;

    private Map<String, Function<String,String>> typeMap = new HashMap<>();


    @PostConstruct
    public void dispatcherInit(){
        //银行
        typeMap.put("1", type->typeService.bankType(type));
        //现金
        typeMap.put("2", type->typeService.cashType(type));
        //微信
        typeMap.put("3", type->typeService.weChatType(type));
        //支付宝
        typeMap.put("4", type->typeService.paidType(type));
    }

    public String getRealType(String type){

        Function<String, String> function = typeMap.get(type);
        if (null != function){
            String result = function.apply(type);
            return result;
        }
        return "未查询到支付方式";
    }

}
