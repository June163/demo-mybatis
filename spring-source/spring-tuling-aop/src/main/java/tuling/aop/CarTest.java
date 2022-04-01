package tuling.aop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * desc:
 *
 * @author zhang
 * @date 2021/5/31 10:45
 */
public class CarTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);

        Object car = context.getBean("car");
        System.out.println(car);
    }
}
