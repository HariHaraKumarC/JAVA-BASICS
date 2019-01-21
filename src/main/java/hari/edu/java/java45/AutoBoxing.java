package hari.edu.java.java45;

import org.apache.log4j.Logger;

/**
 * Created by harih on 8/18/2018.
 */
public class AutoBoxing {
    private static final Logger logger=Logger.getLogger(AutoBoxing.class);

    public static void main(String[] args){
        int a=1_000;
        Integer b=2_000;
        int result=a+b; // autoboxing java 45 feature
        logger.debug("Result of "+a+ " + "+b+" = "+result);
    }
}
