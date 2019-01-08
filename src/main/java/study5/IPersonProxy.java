package study5;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IPersonProxy implements InvocationHandler{
    private Object target;

    public IPersonProxy(Object target) {
        this.target= target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before proxy");
        Object result = method.invoke(target,args);
        System.out.println("after proxy");
        return result;
    }

    public static void main(String[] args) {
        IPerson iPerson = new IPersonImpl();
        InvocationHandler invocationHandler = new IPersonProxy(iPerson);
        IPerson iPerson1 = (IPerson) Proxy.newProxyInstance(IPerson.class.getClassLoader(), iPerson.getClass().getInterfaces(),invocationHandler );
        System.out.println(iPerson1.say());
        System.out.println(iPerson1.getClass());
    }
}
