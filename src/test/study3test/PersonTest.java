package study3test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study3.IPerson;

/**
 * Created by li on 1/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop.xml")
public class PersonTest {

    @Autowired
    @Qualifier("person")
    IPerson person;

    @Test
    public void test() {
//        System.out.println(proxyFactoryBean.getClass());
        person.goodSay();
        person.say();
    }

}