package com.autoframework.element;


import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementUtils extends SeleniumDriver {

    public static WebElement findElement(final By by){

        WebElement webElement=null;
        try {
            //显示等待
            webElement=new WebDriverWait(driver,10).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });
        }catch (Exception e){
            System.out.println("元素:"+by+"查找超时!!!");
            e.printStackTrace();
        }

        return webElement;

    }


    public static List<WebElement> findElements(final By by){
        List<WebElement> webElements=null;
        try{
            webElements=new WebDriverWait(driver,10).until(new ExpectedCondition<List<WebElement>>() {
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(by);
                }
            });
        }catch (Exception e){
            System.out.println("元素:"+by+"查找超时");
            e.printStackTrace();
        }
        return webElements;
    }

}
