package com.autoframework.cases;

import com.autoframework.action.Action;
import com.autoframework.driver.SeleniumDriver;
import com.autoframework.element.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class sendEmail {

    @Test
    public void case1(){
        WebDriver driver = SeleniumDriver.open("chrome");
        Action.get(driver,"https://mail.163.com");
        Action.click(By.xpath("//*[@id=\"lbNormal\"]"));
        Action.swithTo(driver,By.xpath("//*[@id=\"loginDiv\"]/iframe"));
        Action.sendText(By.name("email"),"tanxueqi1");
        Action.sendText(By.name("password"),"lyh840115");
        Action.click(By.id("dologin"));
        Action.click(By.xpath("//*[text()=\"写 信\"]"));
        Action.sendText(By.className("nui-editableAddr-ipt"),"535223120@qq.com");
        Action.sendText(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input"),"我是中国人");
        //上传文件
        Action.sendText(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input"),"C:\\Users\\T\\Desktop\\UI自动化知识点\\log4j\\log4j.properties");
        Action.swithTo(driver,By.className("APP-editor-iframe"));
        Action.sendText(By.xpath("/html/body"),"加油。。。");
        Action.switchToDefaultContent(driver);
        Action.click(By.xpath("//*[text()=\"发送\"]"));
    }
}
