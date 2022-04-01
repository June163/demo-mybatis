package tuling.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * desc:
 *
 * @author zhang
 * @date 2021/5/31 10:32
 */
@Configuration
//@Conditional(value = Match.class)
public class CarConfig {


    @Bean("car")
//    @Conditional(value = Match.class)
    public Car getCar(){
        return new Car("普通车辆", BigDecimal.TEN);
    }
}
