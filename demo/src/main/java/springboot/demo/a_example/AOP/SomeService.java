package springboot.demo.a_example.AOP;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
    public void doSomeService() {
        System.out.println("doSomeService");
    }
}
