package multi;

/**
 * Created by li on 1/25/18.
 */
public class ReadyThread {
    private static boolean ready;
    private static int num;
    private static class Ready extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true){
        new Ready().start();
        num = 42;
        ready =true;
        }
    }
}
