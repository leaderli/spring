package study2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by li on 1/12/18.
 */
public class AroundAdvice implements MethodInterceptor {
    public void before(){
        System.out.println("around before");
    }
    public void after(){
        System.out.println("around after");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }
}
