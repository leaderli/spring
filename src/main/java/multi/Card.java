package multi;

import java.io.Serializable;

/**
 * Created by li on 1/26/18.
 */
public class Card implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
