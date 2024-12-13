package com.qapitol.fileoperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperation {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Qapitol QA\\IdeaProjects\\FileHandling\\data.properties";
        try
                (
                FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(filePath,true)
                ) {

            Properties prop = new Properties();
            prop.load(fis);

            System.out.println(prop.getProperty("name"));
            System.out.println(prop.getProperty("address"));
            //fis.close();
//            prop.setProperty("name", "abc");
//            prop.setProperty("address", "xvb");
            prop.setProperty("subject", "cs");
            prop.store(fos, "updated");
            System.out.println(prop.getProperty("subject"));
            System.out.println(prop.getProperty("address"));
            System.out.println(prop.getProperty("name"));
            //prop.remove("subject");


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
