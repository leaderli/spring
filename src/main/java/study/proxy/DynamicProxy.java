package study.proxy;

import util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by li on 1/11/18.
 */
public class DynamicProxy implements InvocationHandler{
    private Object delagate;
    private Log log = new Log();
    public Object bind(Object delagate){
        this.delagate = delagate;
        return Proxy.newProxyInstance(delagate.getClass().getClassLoader(),delagate.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result =null;
        log.log("DynamicProxy before ");
        result = method.invoke(delagate,args);
        log.log("DynamicProxy after");
        return result;
    }
}
