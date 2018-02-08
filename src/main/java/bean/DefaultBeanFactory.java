package bean;


import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by li on 1/19/18.
 */
public class DefaultBeanFactory {
    private BeanDefinitionRegister DEFINITIONS = new BeanDefinitionRegister();
    private final SingletonBeanRegistry SINGLETONS = new SingletonBeanRegister();

    public Object getBean(String id){
        if(!DEFINITIONS.containsBeanDefinition(id)){
            throw  new RuntimeException(id +" not exists");
        }
        BeanDefinition bd = DEFINITIONS.getBeanDefinition(id);
        if(bd.getScope() == BeanDefinition.SCOPE_SINGLETON){
            if(!SINGLETONS.containsSingleton(id)){
                SINGLETONS.registerSingleton(id,createBean(bd));
            }
            return SINGLETONS.getSingleton(id);
        }
        if (bd.getScope() == BeanDefinition.SCOPE_PROTOTYPE){
            return createBean(bd);
        }
        throw new RuntimeException("illegal bean");
    }

    public void  registerBeanDefiniton(BeanDefinition bd){
        DEFINITIONS.registerBeanDefinition(bd.getId(),bd);
    }
    private Object createBean(BeanDefinition bd) {
        try {
            Class<?> c = Class.forName(bd.getClazz());
            return c.getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
