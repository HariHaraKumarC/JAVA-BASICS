package hari.edu.java.fileHandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import hari.edu.java.fileHandling.pojo.Message;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;

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
            ArrayList<Message> messageList=new ArrayList<Message>();
            while((readLine=bufferedReader.readLine())!=null){
                System.out.println("Line Number " + lineNumber + " ..");
                Message msg=parseLineContents(readLine);
                messageList.add(msg);
                lineNumber++;
            }
        }catch(IOException ex){
            System.out.println("IO Exception occured while reading the file.."+ ex);
        }
    }

    public Message parseLineContents(String lineContent){
        Message msg=null;
        String formatType=getFormatType(lineContent);
        System.out.println("Format Type : "+ formatType);
        if(formatType.equalsIgnoreCase("XML")){
            msg=parseXML(lineContent);
            System.out.println("Message Details > "+ msg.toString());
        }else if(formatType.equalsIgnoreCase("JSON")){
            msg=parseJSON(lineContent);
            System.out.println("Message Details > "+ msg.toString());
        }
        return msg;
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

    /**
     * Xml String to Pojo
     * @param xml
     * @return Message
     */
    public Message parseXML(String xml){
        Message message=null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            StringReader reader=new StringReader(xml);
            message=(Message)jaxbUnMarshaller.unmarshal(reader);
        }catch(JAXBException e){
            System.out.println("JAXB Exception occured while unmarshalling the Xml.."+ e);
        }
        return message;
    }

    public Message parseJSON(String json){
        Message message=null;
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            message=(Message)objectMapper.readValue(json,Message.class);
        }catch(IOException e){
            System.out.println("IO Exception occured while unmarshalling the JAXB.."+ e);
        }
        return message;
    }

}
