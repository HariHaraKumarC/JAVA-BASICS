package hari.edu.java.java7;

import org.apache.log4j.Logger;

/**
 * Created by harih on 8/18/2018.
 */
public class SwitchString {
    private static final Logger logger=Logger.getLogger(SwitchString.class);

    public static void main(String[] args){
        String[] operations={"start","pause","resume","stop"};
        for(String operation:operations){
            switch(operation){ //String input to the switch block Java 7 feature
                case "start":
                    logger.debug("Machine Started");
                    break;
                case "stop":
                    logger.debug("Machine Stopped");
                    break;
                case "pause":
                    logger.debug("Machine Paused");
                    break;
                case "resume":
                    logger.debug("Machine Resumed");
                    break;
                default:
                    logger.debug("Operation Not Supported");
                    break;
            }
        }
    }
}
