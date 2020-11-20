package springboot.demo.a_example.AOP;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
    public void doSomeService() {
        //处理某些业务
        System.out.println("doSomeService");
    }
}
