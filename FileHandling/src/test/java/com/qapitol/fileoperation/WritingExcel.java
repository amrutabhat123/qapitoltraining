package com.qapitol.fileoperation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingExcel {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("demo");
        Row row = sheet.createRow(0);
        Cell col1 = row.createCell(0);
        col1.setCellValue("id");
        Cell col2 = row.createCell(1);
        col2.setCellValue("age");
        FileOutputStream fis=new FileOutputStream("C:\\Users\\Qapitol QA\\Downloads\\Book 10.xlsx");
        workbook.write(fis);
        workbook.close();





    }
}
