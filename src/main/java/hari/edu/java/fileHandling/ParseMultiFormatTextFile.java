package hari.edu.java.fileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by harih on 7/17/2018.
 */
public class ParseMultiFormatTextFile {

    public static void main(String args[]){
        ParseMultiFormatTextFile obj= new ParseMultiFormatTextFile();
        String fileName="files/text/multiFormatTestFile1.txt";
        obj.readFileContents(fileName);
    }

    public void readFileContents(String fileName){
        ClassLoader classLoader=getClass().getClassLoader();
        File file= new File(classLoader.getResource(fileName).getFile());
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader(file))){
            String readLine="";
            int lineNumber=1;
            while((readLine=bufferedReader.readLine())!=null){
                System.out.println("Line Number " + lineNumber + " ..");
                parseLineContents(readLine);
                lineNumber++;
            }
        }catch(IOException ex){
            System.out.println("IO Exception occured while reading the file.."+ ex);
        }
    }

    public void parseLineContents(String lineContent){
        String formatType=getFormatType(lineContent);
        System.out.println("Format Type : "+ formatType);
        if(formatType.equalsIgnoreCase("XML")){
            parseXML(lineContent);
        }
    }

    public String getFormatType(String lineContent){
        String formatType="";
        if(lineContent.startsWith("{")){
            formatType="JSON";
        }else if(lineContent.startsWith("<")){
            formatType="XML";
        }else{
            formatType="CSV";
        }
        return formatType;
    }

    public void parseXML(String xml){

    }
}
