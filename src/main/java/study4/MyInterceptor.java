package study4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by li on 1/15/18.
 */
@Aspect
@Component
public class MyInterceptor {
    @Pointcut("execution(* study4..setA*(..))")
    private void declare(){}

    @Around("declare()")
    public void  log(ProceedingJoinPoint point){
        System.out.println("before");
        System.out.println(point.getTarget().getClass().getSimpleName()+"."+point.getSignature().getName()+" "+point.getArgs()[0]);
        System.out.println("after");
    }
}
