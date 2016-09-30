package utils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Properties;


public class PropertyManager {

    // public static void main(String[] args) throws Exception {
    public static void loadProperties() throws Exception {
        // set up new properties object
        // from file "myProperties.txt"
        FileInputStream envFile = new FileInputStream("env\\test1.properties");
        System.out.println(System.getProperty("envName"));
        System.out.println(System.getProperty("browserName"));
        if (System.getProperty("envName")==(null)){
            System.setProperty("envName","test1");
            //System.setProperty("envName","test3");
        }
        if (System.getProperty("browserName")==(null)){
            //System.setProperty("browserName","chrome");
            System.setProperty("browserName","firefox");
        }
        switch (System.getProperty("envName")) {
            case "test1":
                envFile = new FileInputStream("env\\test1.properties");
                FileUtils.copyFile(new File("env\\test1.properties"),new File("src\\test\\resources\\environment.properties"));
                break;
            case "test3":
                envFile = new FileInputStream("env\\test3.properties");
                FileUtils.copyFile(new File("env\\test3.properties"),new File("src\\test\\resources\\environment.properties"));
                break;
            case "demo":
                envFile = new FileInputStream("env\\demo.properties");
                FileUtils.copyFile(new File("env\\demo.properties"),new File("src\\test\\resources\\environment.properties"));
                break;
            case "localdemo":
                envFile = new FileInputStream("env\\localdemo.properties");
                FileUtils.copyFile(new File("env\\localdemo.properties"),new File("src\\test\\resources\\environment.properties"));
                break;
        }
        File file = new File("src\\test\\resources\\environment.properties");
        switch (System.getProperty("browserName")) {
            case "chrome":
                FileUtils.writeStringToFile(file, "\n\nbrowser=chrome", true);
                break;
            case "firefox":
                FileUtils.writeStringToFile(file, "\n\nbrowser=firefox", true);
                break;
        }
        //envFile = new FileOutputStream("src\\test\\resources\\environment.properties");
        envFile = new FileInputStream("src\\test\\resources\\environment.properties");
        Properties p = new Properties(System.getProperties());
        p.load(envFile);
        //p.store(envFile,"");
        // set the system properties
        System.setProperties(p);
        // display new properties
        //System.getProperties().list(System.out);
    }

}