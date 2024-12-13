package com.qapitol.fileoperation;




import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonWriter {
    public  static  void main(String[] args) throws IOException {

        Student s=new Student();
        s.setId(1);
        s.setName("abc");
        s.setAge(12);
        ObjectMapper objectMapper = new ObjectMapper();


            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\Qapitol QA\\IdeaProjects\\FileHandling\\src\\test\\java\\com\\qapitol\\fileoperation\\jsontxt.json"), s);

            // Output success message
            System.out.println("JSON file written successfully");


        Student sread = objectMapper.readValue(new File("C:\\Users\\Qapitol QA\\IdeaProjects\\FileHandling\\src\\test\\java\\com\\qapitol\\fileoperation\\jsontxt.json"), Student.class);

            System.out.println(sread.getId());
            System.out.println(sread.getName());
            System.out.println(sread.getAge());




    }
}
