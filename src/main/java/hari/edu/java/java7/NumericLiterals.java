package hari.edu.java.java7;

import org.apache.log4j.Logger;

/**
 * Created by harih on 8/18/2018.
 */
public class NumericLiterals {
    private static final Logger logger=Logger.getLogger(NumericLiterals.class);

    public static void main(String[] args){
        int num1=1_000; // Numeric Literal Java 7 feature
        int num2=2_000;
        int addResult=num1+num2;
        logger.debug("Result of "+num1+ " + "+num2+" = "+addResult);
    }
}
