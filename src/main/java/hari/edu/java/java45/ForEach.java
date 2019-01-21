package hari.edu.java.java45;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by harih on 8/18/2018.
 */
public class ForEach {
    private static final Logger logger=Logger.getLogger(ForEach.class);

    public static void main(String[] args){
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("HariHaraKumar.C");
        arrayList.add("UshaNandhini.H");
        for (String name:arrayList) { // for each java 45 feature
            logger.debug(name);
        }
    }
}
