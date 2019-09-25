package com.autoframework.MyAssert;

import com.autoframework.action.Action;
import com.autoframework.driver.SeleniumDriver;
import com.autoframework.tools.MyAssert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MyAssertTest {

    @Test
    public void test(){
        WebDriver driver = SeleniumDriver.open("chrome");
        Action.get(driver,"https://www.baidu.com");
        MyAssert.assertEquals("123","456");
    }
}
