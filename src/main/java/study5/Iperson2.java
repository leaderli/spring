package study5;

public class Iperson2 extends IPersonImpl{
    @Override

    public String say() {
        System.out.println("---------");
        String result = super.say();
        System.out.println("---------");
        return  result;
    }
}
