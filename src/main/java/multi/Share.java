package multi;

/**
 * Created by li on 1/22/18.
 */
public class Share {
    private char c;
    private volatile boolean writeAble = true;

    public synchronized void  setCharacter(char c){
        while (!writeAble){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.c = c;
        writeAble = false;
        notify();
    }

    public synchronized char getCharacter(){
        while (writeAble){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeAble = true;
        notify();
        return this.c;
    }

    public static void main(String[] args) {
        Share share = new Share();
        Customer customer = new Customer(share);
        Producer producer = new Producer(share);
        producer.start();
        customer.start();
    }
}

class Producer extends Thread{
    private Share share;

    public Producer(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        System.out.println("-------product------------");
        for(char c = 'a';c<='z';c++){
            share.setCharacter(c);
            System.out.println("product "+c);
        }
    }
}
class Customer extends Thread{
    private Share share;

    public Customer(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        System.out.println("-------customer------------");
        char c  ;
        while (true){
            c=share.getCharacter();
            System.out.println("customer " +c);
            if(c == 'z') {
                break;
            }
        }
    }
}