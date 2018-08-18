package hari.edu.java.java7;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by harih on 8/18/2018.
 */
public class TryWithResources {
    private static final Logger logger = Logger.getLogger(TryWithResources.class);

    public static void main(String[] args) {
        String fileName = "files/text/testFile1.txt";
        TryWithResources obj=new TryWithResources();
        obj.writeContentToFile(fileName);
    }

    public void writeContentToFile(String fileName) {
        String content="Hello Friends, Welcome to Java World!";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) { //try with resources Java 7 feature
            bufferedWriter.write(content);
            logger.debug("Content Written to the file successfully.");
        } catch (IOException e) {
            logger.error("Exception occured while writing the contents to the file." +e);
        }
    }
}