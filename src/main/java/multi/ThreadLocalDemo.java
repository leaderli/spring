package multi;

/**
 * Created by li on 1/24/18.
 */
public class ThreadLocalDemo {
    private static volatile ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                LOCAL.set(name);
                System.out.println("name="+LOCAL.get());
            }
        };

        Thread t1 = new Thread(runnable);
        t1.setName("A");

        Thread t2 = new Thread(runnable);
        t2.setName("B");

        t1.start();
        t2.start();
    }
}
