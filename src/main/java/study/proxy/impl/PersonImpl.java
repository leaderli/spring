package study.proxy.impl;

import study.proxy.IPerson;
import util.Log;

/**
 * Created by li on 1/11/18.
 */
public class PersonImpl implements IPerson {
    private Log log = new Log();
    @Override
    public void say() {
        log.log("PersonImpl say()");
    }
}
