package multi;

/**
 * @author li
 * @date 1/25/18
 */
public class UnsafeQueue {
    private volatile int value ;
    private int getNext(){
        value = value+1;
       return value;
    }

    public static void main(String[] args) {
        final UnsafeQueue unsafeQueue = new UnsafeQueue();
        Runnable runnable=() -> {
            while (true){
            System.out.println(Thread.currentThread().getName()+" "+ unsafeQueue.getNext());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }
        };

        Thread a = new Thread(runnable);
        a.setName("A");
        Thread b = new Thread(runnable);
        b.setName("B");
        a.start();
        b.start();
    }
}
