package study.proxy;

import org.junit.Test;
import study.proxy.impl.PersonImpl;

/**
 * Created by li on 1/11/18.
 */
public class IPersonTest {
    public static final String HELLO="hello";
    @Test
    public void say() {
        IPerson iPerson = new PersonProxy(new PersonImpl());
        iPerson.say();
    }

}