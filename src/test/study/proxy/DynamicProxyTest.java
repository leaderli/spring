package study.proxy;

import org.junit.Test;
import study.proxy.impl.PersonImpl;

/**
 * Created by li on 1/11/18.
 */
public class DynamicProxyTest {
    @Test
    public void test1(){
        DynamicProxy proxy = new DynamicProxy();
        IPerson person = (IPerson) proxy.bind(new PersonImpl());
        person.say();
    }

}