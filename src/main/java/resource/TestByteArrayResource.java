package resource;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by li on 1/22/18.
 */
public class TestByteArrayResource {

    public static void main(String[] args) {
        Resource resource = new ByteArrayResource("hello".getBytes());
        if(resource.exists()){
           dumpStream(resource);
        }
    }
    static void dumpStream(Resource resource) {
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
