package com.autoframework.action;

import com.autoframework.driver.SeleniumDriver;
import com.autoframework.tools.DateFormat;
import com.autoframework.tools.MyFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends SeleniumDriver {

    static String path=System.getProperties().getProperty("user.dir")+"/error/";
    /**
     * 错误截图
     */
    public static void screenShots(){
        WebDriver augment = new Augmenter().augment(driver);
        File file = ((TakesScreenshot) augment).getScreenshotAs(OutputType.FILE);
        try {
            MyFile myFile = new MyFile();
            //根据日期创建文件夹
            myFile.createFile(path+ DateFormat.format(DateFormat.CHECK_LOG_FORMAT));
            FileUtils.copyFile(file,new File(path+DateFormat.format(DateFormat.CHECK_LOG_FORMAT)+"/"+
                    DateFormat.format(DateFormat.DATE_FORMAT)+".jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void screenShots(String name){
        WebDriver augment = new Augmenter().augment(driver);
        File file = ((TakesScreenshot) augment).getScreenshotAs(OutputType.FILE);
        try {
            MyFile myFile = new MyFile();
            //根据日期创建文件夹
            myFile.createFile(path+ DateFormat.format(DateFormat.DATE_FORMAT));
            FileUtils.copyFile(file,new File(path+DateFormat.format(DateFormat.DATE_FORMAT)+
                    "/"+name+".jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
