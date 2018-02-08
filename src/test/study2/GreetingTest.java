package study2;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * Created by li on 1/12/18.
 */
public class GreetingTest {
    @Test
    public void say() throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.say();
    }

    @Test
    public void say2() throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new AroundAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.say();
    }

    @Test
    public void say3() throws Exception {
        ProxyFactoryBean proxyFactory = new ProxyFactoryBean();
        proxyFactory.setInterfaces(Love.class);
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new LoveAdvice());
        proxyFactory.setProxyTargetClass(true);
        Greeting greeting = (Greeting) proxyFactory.getObject();
        greeting.say();
        Love love = (Love) greeting;
        love.display("hello");
    }
}