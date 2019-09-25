package com.autoframework.action;

import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class ActionTest {

    @Test
    public void testClick() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        Action.get(driver,"https://baidu.com");
        Action.sendText(By.id("kw"),"selenium");
        Thread.sleep(3000);
        Action.click(By.id("su"));
        SeleniumDriver.closedAll();
    }

    @Test
    public void getText(){
        WebDriver driver = SeleniumDriver.open("chrome");
        Action.get(driver,"https://www.baidu.com");
        String text = Action.getText(By.xpath("//*[@id=\"u1\"]/a[1]"));
        System.out.println(text);
        SeleniumDriver.closedAll();
    }

    @Test
    public void getTexts(){
        WebDriver driver = SeleniumDriver.open("chrome");
        Action.get(driver,"https://www.baidu.com");
        List texts = Action.getTexts(By.xpath("//*[@id=\"u1\"]/a"));
        for(int i=0;i<texts.size();i++){
            System.out.println(texts.get(i));
        }
        System.out.println(texts.get(2));
        SeleniumDriver.closedAll();
    }

    @Test
    public void doubleClickTest(){
        WebDriver driver = SeleniumDriver.open("chrome");
        Action.get(driver,"https://www.baidu.com");
        Action.doubleClick(driver,By.id("su"));
    }
}
