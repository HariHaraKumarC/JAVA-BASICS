package hari.edu.java.fileHandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by HariHaraKumar on 26/07/2018.
 */
public class NewFileCreator {

    public static void main(String args[]){
        String fileDir="C:\\Data\\Hari\\Git\\Local_Repository\\JAVA-BASICS\\src\\main\\resources\\files\\text\\";
        String fileName=fileDir+"testFileCreator.txt";
        NewFileCreator fileCreator=new NewFileCreator();
        fileCreator.createNewFile(fileName);
        fileCreator.deleteFile(fileName);
        fileCreator.listFileNamesInDirectory(fileDir);
    }

    /**
     * Create New file
     * @param fileName
     */
    public void createNewFile(String fileName){
        File file= new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Create New File > File created successfully");
            } else {
                System.out.println("Create New File > File already exists");
            }
        }catch(IOException io){
            System.out.println("Create New File > Exception occured during file creation"+io);
        }
    }

    /**
     * Delete File
     * @param fileName
     */
    public void deleteFile(String fileName){
        File file= new File(fileName);
        if (file.delete()) {
            System.out.println("Create New File > File deleted successfully");
        } else {
            System.out.println("Create New File > File not exists");
        }
    }

    public void listFileNamesInDirectory(String dirName){
        File dir= new File(dirName);
        System.out.println("List File Names inside the Directory > " +dirName);
        if (dir.isDirectory()) {
            for(File file:dir.listFiles()){
                System.out.println(file.getName());
            }
        } else {
            System.out.println("List File Names inside the Directory > Invalid Directory");
        }
    }

}
