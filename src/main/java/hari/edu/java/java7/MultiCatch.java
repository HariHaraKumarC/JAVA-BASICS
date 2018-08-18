package hari.edu.java.java7;

import org.apache.log4j.Logger;

/**
 * Created by harih on 8/18/2018.
 */
public class MultiCatch {
    private static final Logger logger=Logger.getLogger(MultiCatch.class);

    public static void main(String[] args){
        int[] num=new int[3];
        num[0]=0;
        num[1]=2_000;
        try{
            num[2]=num[1]/num[2];
            logger.debug("Result of "+num[0]+ " / "+num[1]+" = "+num[2]);
        }catch(ArithmeticException | ArrayIndexOutOfBoundsException e){ //Multi Catch Java 7 feature
            logger.error("Exception occured "+e);
        }
    }
}
