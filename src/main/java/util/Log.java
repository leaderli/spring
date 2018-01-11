package util;

import org.apache.log4j.Logger;

/**
 * Created by li on 1/11/18.
 */
public class Log {
    private static Logger logger = Logger.getLogger(Log.class);
    public static void log(Object o){
        logger.debug(o.toString());
    }
}
