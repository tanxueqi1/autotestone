package com.autoframework.element;

import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElementUtilsTest {


    @Test
    public void findElementTest(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("C:\\Users\\T\\Desktop\\selenium_html\\index.html");
        WebElementUtils.findElement(By.className("wait")).click();
        String text = WebElementUtils.findElement(By.className("red")).getText();
        System.out.println(text);
        Assert.assertEquals(text,"wait for display");

    }

}
