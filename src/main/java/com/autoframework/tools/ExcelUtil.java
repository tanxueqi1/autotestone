package com.autoframework.tools;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelUtil {

    public static Workbook getWorkbook(String filePath){
        Workbook wb=null;
        try{
            if(filePath.endsWith(".xls")){
                File file = new File(filePath);
                InputStream is = new FileInputStream(file);
                wb = new HSSFWorkbook(is);
            }else if(filePath.endsWith(".xlsx")){
                wb = new XSSFWorkbook(filePath);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return wb;
    }

    public static String getCellValue(Sheet sheet,int rowNum,int cellNum){
        Cell cell = sheet.getRow(rowNum).getCell(cellNum);
        String value = ExcelUtil.getCellValue(cell);
        return value;
    }

    public static String getCellValue(Cell cell){
        String value="";
        switch (cell.getCellTypeEnum()){
            case STRING:
                value = String.valueOf(cell.getRichStringCellValue());
                return value;
            case NUMERIC:
                value=String.valueOf((int)cell.getNumericCellValue());
                return value;
            case BOOLEAN:
                value=String.valueOf(cell.getBooleanCellValue());
                return value;
            case FORMULA:
                value=String.valueOf(cell.getCellFormula());
                return value;
        }
        return value;
    }
}
