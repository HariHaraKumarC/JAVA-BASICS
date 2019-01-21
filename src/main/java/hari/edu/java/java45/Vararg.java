package hari.edu.java.java45;

import org.apache.log4j.Logger;

/**
 * Created by harih on 8/18/2018.
 */
public class Vararg {
    private static final Logger logger=Logger.getLogger(Vararg.class);

    public static void main(String[] args){
        Vararg object=new Vararg();
        object.testVararg1();
        object.testVararg1("Hari","Usha");
        object.testVararg2(100,"Hari","Usha");
        object.testVararg2(200,"Bose","Vanitha");
    }

    public void testVararg1(String... names){ // vararg java45 feature
        for (String name:names) {
            logger.debug(name);
        }
    }

    public void testVararg2(int num,String... names){
        logger.debug("Family Number : "+num);
        for (String name:names) {
            logger.debug(name);
        }
    }
}
