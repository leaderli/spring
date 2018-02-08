package multi;

/**
 * Created by li on 1/25/18.
 */
public class InheritableThreadLocalDemo {
    private static volatile ThreadLocal<Integer> intVal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Runnable r1 =()->{
          intVal.set(10);
          Runnable r2 =() -> {
              System.out.println(intVal.get());
          };
          new Thread(r2).start();
        };
        new Thread(r1).start();
    }
}
