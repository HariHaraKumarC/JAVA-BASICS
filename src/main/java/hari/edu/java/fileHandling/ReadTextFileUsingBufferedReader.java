package hari.edu.java.fileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by harih on 7/17/2018.
 * Read and display the file contents line by line using Buffered Reader
 */
public class ReadTextFileUsingBufferedReader {

    public static void main(String args[]){
        ReadTextFileUsingBufferedReader obj= new ReadTextFileUsingBufferedReader();
        String fileName="files/text/testFile1.txt";
        obj.printFileContents(fileName);
    }

    public void printFileContents(String fileName){
        ClassLoader classLoader=getClass().getClassLoader();
        File file= new File(classLoader.getResource(fileName).getFile());
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader(file))){
            String readLine="";
            System.out.println("Reading Lines from the file..");
            while((readLine=bufferedReader.readLine())!=null){
                System.out.println(readLine);
            }
            System.out.println("Completed Reading Lines from the file..");
        }catch(IOException ex){
            System.out.println("IO Exception occured while reading the file.."+ ex);
        }
    }
}
