package multi;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 1/26/18.
 */
public class SubCard extends Card{

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Map<Object,Object> map = new HashMap<>();
        map.put(null,null);
        System.out.println(map.containsKey(null));
    }
}
