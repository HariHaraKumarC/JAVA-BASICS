package hari.edu.java.java7;

import org.apache.log4j.Logger;

/**
 * Created by harih on 8/18/2018.
 */
public class BinaryLiterals {
    private static final Logger logger=Logger.getLogger(BinaryLiterals.class);

    public static void main(String[] args){
        int num1=0B101; // Binary Literal Java 7 feature
        int num2=0b101;
        int addResult=num1+num2;
        logger.debug("Result of "+num1+ " + "+num2+" = "+addResult);
    }
}
