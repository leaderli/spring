package multi;

/**
 * Created by li on 1/23/18.
 */
public class TestThreadException {
    public static void main(String[] args) {
     int[] m ={1};
        System.out.println(m.length);
    }
}


class InThread extends Thread {
    private volatile boolean flag = false;
    @Override
    public void run() {
        int i = 5;
        while (true){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i--;
            System.out.println(5/i);
        }
    }
}