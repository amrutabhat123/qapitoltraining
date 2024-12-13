package com.qapitol.fileoperation;

import java.io.*;

public class FIlereadingwriting {

    public static void main(String[] args) throws IOException {

        File fl=new File("textFile");
        if(!fl.exists()){
            fl.createNewFile();

        }
        BufferedWriter bw=new BufferedWriter(new FileWriter(fl));
        bw.write("this is a  file demo file");
        bw.newLine();
        bw.write("this is a  file demo file");
        bw.newLine();
        bw.write("this is a  file demo file");
        bw.newLine();
        bw.append("this is demo file class file");
        bw.close();

        BufferedReader br=new BufferedReader(new FileReader(fl));
        String data;
        while((data=br.readLine())!=null){
            System.out.println(data);
        }

      br.close();


    }

}
