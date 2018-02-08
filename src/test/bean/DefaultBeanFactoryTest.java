package bean;

import org.junit.Test;

/**
 * Created by li on 1/19/18.
 */
public class DefaultBeanFactoryTest {
    @Test
    public void getBean() throws Exception {
        DefaultBeanFactory dbf = new DefaultBeanFactory();
        BeanDefinition bd = new BeanDefinition();
        bd.setId("bean");
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        bd.setClazz(HelloBean.class.getName());
        dbf.registerBeanDefiniton(bd);
        System.out.println(dbf.getBean("bean"));
        System.out.println(dbf.getBean("bean"));

        bd = new BeanDefinition();
        bd.setId("bean1");
        bd.setScope(BeanDefinition.SCOPE_SINGLETON);
        bd.setClazz(HelloBean.class.getName());
        dbf.registerBeanDefiniton(bd);
        System.out.println(dbf.getBean("bean1"));
        System.out.println(dbf.getBean("bean1"));

        bd = new BeanDefinition();
        bd.setId("bean2");
        bd.setClazz(HelloBean.class.getName());
        dbf.registerBeanDefiniton(bd);
        System.out.println(dbf.getBean("bean2"));
        System.out.println(dbf.getBean("bean2"));
    }

}