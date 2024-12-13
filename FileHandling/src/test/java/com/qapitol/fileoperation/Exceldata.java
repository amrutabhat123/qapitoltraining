package com.qapitol.fileoperation;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceldata {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream("C:\\Users\\Qapitol QA\\Downloads\\Book 8.xlsx"));
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastrow = sheet.getLastRowNum();
        int cell = sheet.getRow(0).getLastCellNum();
        XSSFRow row = sheet.getRow(0);

        for(int i=0;i<=lastrow;i++){
             row= sheet.getRow(i+1);
            for(int j=0;j<cell;j++){
                System.out.println(row.getCell(j));
            }

        }
        

    }
}
