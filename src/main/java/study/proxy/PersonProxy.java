package study.proxy;

import util.Log;

/**
 * Created by li on 1/11/18.
 */
public class PersonProxy implements IPerson {
    private IPerson person;
    private Log log = new Log();

    public PersonProxy(IPerson iPerson) {
        this.person = iPerson;
    }

    @Override
    public void say() {
        log.log("proxy before say");
        person.say();
        log.log("proxy after say");
    }
}
