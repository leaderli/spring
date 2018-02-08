package study4test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study4.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 1/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop4.xml")
public class PersonTest {

    @Autowired
    @Qualifier("person")
    Person person;

    @Test
    public void test() throws IllegalAccessException, InvocationTargetException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "tim");
        map.put("age", 100);
        System.out.println("--------------------");
        Class c = person.getClass().getSuperclass();
        System.out.println(c);
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("set")) {
                name = name.substring(3, 4).toLowerCase() + name.substring(4);
                System.out.println(name);
                method.invoke(person, map.get(name));
            }
        }
        System.out.println(person);
    }

}