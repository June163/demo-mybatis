package com.pindao.infrabase.mdm;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : wangyongkang
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDubbo(scanBasePackages = {"com.pindao.infrabase"})
public class MdmCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdmCenterApplication.class, args);
    }

}
