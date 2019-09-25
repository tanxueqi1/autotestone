package com.autoframework.action;

import com.autoframework.driver.SeleniumDriver;
import com.autoframework.element.WebElementUtils;
import com.autoframework.logger.LoggerController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Action extends SeleniumDriver {
    final static LoggerController log=LoggerController.getLogger(SeleniumDriver.class);
    //打开网站
    public static void get(WebDriver driver, String url) {
        driver.get(url);
        log.info("打开网站:"+url);
    }

    //点击方法
    public static void click(By by) {
        WebElementUtils.findElement(by).click();
        log.info("点击:"+by);
    }

    //文本框输入方法
    public static void sendText(By by, String text) {
        WebElement element = WebElementUtils.findElement(by);
        element.clear();
        element.sendKeys(text);
        log.info("在文本框为"+by+"输入了"+text);
    }



    //获取文本
    public static String getText(By by) {
        String text = WebElementUtils.findElement(by).getText();
        return text;
    }

    //跳转框架
    public static void swithTo(WebDriver driver,By by) {
        driver.switchTo().frame(WebElementUtils.findElement(by));
    }

    //跳出框架
    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //获取多个文本值
    public static List getTexts(By by) {
        List list = new ArrayList();
        List<WebElement> elements = WebElementUtils.findElements(by);
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
            list.add(text);
        }
        return list;
    }

    //双击
    public static void doubleClick(WebDriver driver, By by) {
        Actions actions = new Actions(driver);
        WebElement element = WebElementUtils.findElement(by);
        actions.doubleClick(element).perform();
    }
}
