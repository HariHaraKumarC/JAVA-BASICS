package hari.edu.java.java7;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by harih on 8/18/2018.
 */
public class Diamond {
    private static final Logger logger=Logger.getLogger(Diamond.class);

    public static void main(String[] args){
        ArrayList<String> arrayList=new ArrayList<>(); //Diamond Type Inference Java 7 feature
        arrayList.add("HariHaraKumar.C");
        arrayList.add("UshaNandhini.H");
        for (String name:arrayList) {
            logger.debug(name);
        }
    }
}
