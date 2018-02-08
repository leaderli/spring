package bean;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by li on 1/19/18.
 */
public class SingletonBeanRegister implements SingletonBeanRegistry{
    private final Map<String,Object> BEANS = new ConcurrentHashMap<String, Object>();
    @Override
    public void registerSingleton(String id, Object o) {
            if(BEANS.containsKey(id)){
                throw new RuntimeException(id +" exists");
            }
            BEANS.put(id,o);
    }

    @Override
    public Object getSingleton(String s) {
        return BEANS.get(s);
    }

    @Override
    public boolean containsSingleton(String s) {
        return BEANS.containsKey(s);
    }

    @Override
    public String[] getSingletonNames() {
        return BEANS.keySet().toArray(new String[0]);
    }

    @Override
    public int getSingletonCount() {
        return BEANS.size();
    }
}
