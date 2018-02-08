package multi;

/**
 * Created by li on 1/25/18.
 */
public class LoggingWidget extends Widget{

    @Override
    public synchronized void doSomething(){
        System.out.println("logging");
        super.doSomething();
    }

    public static void main(String[] args) {
        Widget widget = new LoggingWidget();
        widget.doSomething();
    }
}
class Widget{
    public synchronized void doSomething(){
        System.out.println("widget");
    }
}
