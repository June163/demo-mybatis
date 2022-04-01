package tuling.aop;

import lombok.Data;

import java.math.BigDecimal;

/**
 * desc:
 *
 * @author zhang
 * @date 2021/5/31 10:30
 */
@Data
public class Car {

    private String name;

    private BigDecimal price;

    public Car(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Car() {
    }
}
