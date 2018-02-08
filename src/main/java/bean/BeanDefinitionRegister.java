package bean;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by li on 1/19/18.
 */
public class BeanDefinitionRegister {
    private final Map<String,BeanDefinition> DEFINITION = new ConcurrentHashMap<String, BeanDefinition>();

    public void registerBeanDefinition(String id,BeanDefinition bd){
        if(DEFINITION.containsKey(id)){
            throw new RuntimeException(id +" exists");

        }
        DEFINITION.put(id,bd);
    }

    public BeanDefinition getBeanDefinition(String id){
        return  DEFINITION.get(id);
    }

    public boolean containsBeanDefinition(String id){
        return DEFINITION.containsKey(id);
    }
}
