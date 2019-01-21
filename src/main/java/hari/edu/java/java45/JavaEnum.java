package hari.edu.java.java45;

import org.apache.log4j.Logger;

/**
 * Created by harih on 8/18/2018.
 */
public class JavaEnum {
    private static final Logger logger=Logger.getLogger(JavaEnum.class);

    private enum OpeartionStates {START,PAUSE,RESUME,STOP} // enum java 45 feature

    public static void main(String[] args){
        logger.debug("Operation States...");
        for (OpeartionStates opeartionStates:OpeartionStates.values()) { // for each java 45 feature
            logger.debug(opeartionStates);
        }
    }
}
