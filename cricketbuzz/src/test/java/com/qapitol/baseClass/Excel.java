package com.qapitol.baseClass;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel {
    public static Object[][] getData() throws IOException {
        String sheetName = "Sheet1";
        FileInputStream fis = new FileInputStream("C:\\Users\\Qapitol QA\\Downloads\\Book 8.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = workbook.getSheet(sheetName);
        XSSFSheet sheet = workbook.getSheetAt(0);
        // int lastrows = sheet.getLastRowNum();
        int rowcount = sheet.getPhysicalNumberOfRows();
        //System.out.println(rowcount);
        XSSFRow row = sheet.getRow(0);

        int lastcol = row.getLastCellNum();

        Object data[][] = new Object[rowcount - 1][lastcol];
        for (int i = 0; i <rowcount-1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j <lastcol; j++) {
                XSSFCell cell = row.getCell(j);
                //  System.out.println(cell);
                data[i][j] = cell.getStringCellValue();
                // System.out.println(data[i][j]);




            }

        }
        return data;

    }
}
