package com.pindao.infrabase.mdm;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : wangyongkang
 */
@SpringBootApplication
@EnableDubboConfiguration
public class MdmApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdmApiApplication.class, args);
    }

}
