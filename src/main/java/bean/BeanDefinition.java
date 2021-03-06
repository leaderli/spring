package bean;

import org.springframework.context.annotation.Scope;

import javax.swing.*;

/**
 * Created by li on 1/19/18.
 */
@Scope()
public class BeanDefinition {
    public static final int SCOPE_SINGLETON = 0;
    public static final int SCOPE_PROTOTYPE= 1;
    private String id;
    private String clazz;
    private int scope = SCOPE_SINGLETON;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
}
