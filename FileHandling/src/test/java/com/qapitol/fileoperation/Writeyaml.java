package com.qapitol.fileoperation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Writeyaml {

    public static void main(String[] args) throws IOException {
        Map<String, Object> data = new HashMap<>();

          data.put("name","abc");
          data.put("age",12);
          data.put("id",13);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("C:\\Users\\Qapitol QA\\IdeaProjects\\FileHandling\\src\\test\\java\\com\\qapitol\\fileoperation\\yamltext.yaml"),data);
        System.out.println("Data has been written to yamltextfile");


        Student student = mapper.readValue(new File("C:\\Users\\Qapitol QA\\IdeaProjects\\FileHandling\\src\\test\\java\\com\\qapitol\\fileoperation\\yamltext.yaml"), Student.class);

        System.out.println(student.getAge());
        System.out.println(student.getId());
        System.out.println(student.getName());



    }
}
