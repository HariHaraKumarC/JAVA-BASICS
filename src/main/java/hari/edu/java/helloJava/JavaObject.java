package hari.edu.java.helloJava;

/**
 * Created by HariHaraKumar.C on 6/5/2017.
 * Description: Java Object Class and its method
 */
public class JavaObject {
    public static void main(String[] args) {
        //Class Name
        String mainClassName = JavaObject.class.getSimpleName();
        System.out.println("Class Name: " + mainClassName);
        //Parent Class Name
        String parentClassName=JavaObject.class.getSuperclass().getSimpleName();
        System.out.println("Parent Class Name: "+ parentClassName);
    }
}
