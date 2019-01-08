package multi;

/**
 * @author li
 * @date 1/25/18
 */
public class TimerTaskDemo {
    public static final String FUCK = "fuck";

    public static void main(String[] args) {
        System.out.println(getValue(2));
    }

    private static int getValue(int i) {
        int result = 0;
        switch (i) {

            case 1:
                result = result + i;
                break;
            case 2:
                result = result + i * 2;
                break;
            case 3:
                result = result + i * 3;
                break;
            default:
        }
        System.out.println(FUCK);
        return result;

    }
}
