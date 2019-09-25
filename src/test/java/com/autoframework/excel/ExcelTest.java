package com.autoframework.excel;

import com.autoframework.tools.ExcelUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelTest {

    public Object[][] testData(String file){
        List<String> list = new ArrayList<String>();
        Workbook workbook = ExcelUtil.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        //获取总行数
        int rowTotalNum = sheet.getLastRowNum() + 1;
        //总列数  getPhysicalNumberOfCells获取不为空的列个数
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();

        HashMap<String,String>[][] map=new HashMap[rowTotalNum-1][1];
        //对数组中所有元素hashmaap进行初始化
        if(rowTotalNum>1){
            for (int i=0;i<rowTotalNum-1;i++){
                map[i][0]=new HashMap<String, String>();
            }
        }
        //获得首行的列名，作为hashmap的key值
        for(int c=0;c<columns;c++){
            String cellvalue=ExcelUtil.getCellValue(sheet,0,c);
            list.add(cellvalue);
        }
        //遍历所有的单元格的值添加到hashmap中
        for(int r=1;r<rowTotalNum;r++){
            for (int c=0;c<columns;c++){
                String cellvalue=ExcelUtil.getCellValue(sheet,r,c);
                map[r-1][0].put(list.get(c),cellvalue);
            }
        }
        return map;
    }

    @DataProvider(name = "t")
    public Object[][] data1(){
        ExcelTest excelTest = new ExcelTest();
        //return excelTest.testData("C:\\Users\\T\\Desktop\\a.xlsx");
        return excelTest.testData("src\\main\\resources\\txq.xlsx");
    }
    @Test(dataProvider = "t")
    public void test1(HashMap<String,String> data){
        System.out.println(data.get("username"));
        System.out.println(data.get("password"));
        System.out.println(data.get("age"));
    }

}
