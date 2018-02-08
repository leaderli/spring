package study2;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by li on 1/12/18.
 */
public class LoveAdvice extends DelegatingIntroductionInterceptor implements Love {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    @Override
    public void display(String name) {
        System.out.println("LoveAdvice "+name);
    }
}
