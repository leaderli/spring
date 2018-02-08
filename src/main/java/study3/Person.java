package study3;


import org.springframework.stereotype.Component;

/**
 * Created by li on 1/12/18.
 */
@Component
public class Person implements IPerson {

    @Override
    public void say(){
        System.out.println("say");
    }

    @Override
    public void goodSay(){
        System.out.println("good");
    }
}
