package study5;

/**
 * @author li
 */
public class IPersonImpl implements IPerson {
    @Override
    public String say() {
        System.out.println("IPersonImpl say");
        return "impl";
    }
}
