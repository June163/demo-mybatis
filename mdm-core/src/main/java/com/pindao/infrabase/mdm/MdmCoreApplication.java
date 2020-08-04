package com.pindao.infrabase.mdm;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : wangyongkang
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDubboConfiguration
public class MdmCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdmCoreApplication.class, args);
    }

}
