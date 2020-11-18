package springboot.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.demo.a_example.AOP.SomeService;

@SpringBootTest
public class TestAOP {
    @Autowired
    SomeService someService;

    @Test
    public void testAOP() {
        someService.doSomeService();
    }
}
