package springboot.demo.a_example.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



@Aspect        //@Aspect 表示这是一个切面
@Component     //@Component 表示这是一个bean,由Spring进行管理
public class LoggerAspect {
    //表示环切
    @Around(value = "execution(* springboot.demo.a_example.AOP.SomeService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        //查看日志
        System.out.println("start log:"+joinPoint.getSignature().getName());
        //执行目标方法
        Object proceed = joinPoint.proceed();
        //查看日志
        System.out.println("start log:"+joinPoint.getSignature().getName());
        return proceed;
    }
}
