package hari.edu.java.java45;

import org.apache.log4j.Logger;

/**
 * Created by harih on 8/18/2018.
 */
public class Assertion {
    private static final Logger logger=Logger.getLogger(Assertion.class);

    public static void main(String[] args){
        int num1=1_000;
        int num2=-2_000;
        assert num1>0:"Number1 should be greater than zero"; // assert java 45 feature
        assert num2>0:"Number2 should be greater than zero";
        logger.debug("Program completed successfully");
    }
}
