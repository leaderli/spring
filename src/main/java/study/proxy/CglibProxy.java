package study.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import util.Log;

import java.lang.reflect.Method;

/**
 * Created by li on 1/11/18.
 */
public class CglibProxy implements MethodInterceptor{
    private Log log;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        log.log("CglibProxy before");
        result =methodProxy.invokeSuper(o,objects);
        log.log("CglibProxy after");
        return  result;
    }
    public static <T>T instance(Class<T> t){
        Enhancer enhancer = new Enhancer();
        try {
            enhancer.setSuperclass(t.getClass().newInstance());
            enhancer.setCallback(new CglibProxy());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) enhancer.create();
    }
}
