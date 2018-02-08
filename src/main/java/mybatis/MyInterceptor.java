package mybatis;

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
    @Pointcut("execution(* mybatis.Category.set*(..))")
    private void any(){}

    @Around("any()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("before ==========");
        Object[] args = point.getArgs();
        point.proceed(args);
        System.out.println("after  ==========");
    }
}
