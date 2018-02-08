package multi;

import java.util.Random;

/**
 * Created by li on 1/22/18.
 */
public class C3 {
    private int num = 0;
    private boolean flag= true;
    private void  wait1(){
       synchronized (this){
           while (flag){
               try {
                   this.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           System.out.println(--num);
           flag = true;

       }
    }

    private void notify1(){
       synchronized (this){
           num++;
           if(num>0){
           flag = false;
           }
           this.notifyAll();
       }
    }

    public static void main(String[] args) {
        final C3 c = new C3();
        Runnable r1 = () -> {
            while (true){
                c.notify1();
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Runnable r2 = () -> {
            while (true){
                c.wait1();
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(r2);
        t2.start();
    }
}
