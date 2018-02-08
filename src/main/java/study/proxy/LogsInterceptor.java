package study.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import util.Log;

/**
 * Created by li on 1/12/18.
 */
public class LogsInterceptor implements MethodInterceptor {
    private Log log = new Log();
    @Override
    public Object invoke(MethodInvocation methodInvocation) {
        log.log("LogsInterceptor begin");
        Object value = null;
        try {
            value = methodInvocation.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {

            log.log("LogsInterceptor finally");
        }
        log.log("LogsInterceptor after");
        return value;
    }

}
