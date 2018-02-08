package study.proxy;

import org.junit.Test;
import study.proxy.impl.PersonImpl;

/**
 * Created by li on 1/11/18.
 */
public class IPersonTest {
    @Test
    public void say() throws Exception {
        IPerson iPerson = new PersonProxy(new PersonImpl());
        iPerson.say();
    }

}