package mybatis;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by li on 1/15/18.
 */
@Component
@Scope("prototype")
public class Category {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;
    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
