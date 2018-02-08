package study4;

import org.springframework.stereotype.Component;

/**
 * Created by li on 1/15/18.
 */
@Component
public class Person  {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
