package com.autoframework.driver;

import com.autoframework.driver.SeleniumDriver;
import org.testng.annotations.Test;

public class SeleniumDriverTest {

    @Test
    public void openTest() throws InterruptedException {
        SeleniumDriver.open("chrome");
        Thread.sleep(3000);
        SeleniumDriver.closedAll();
    }
}
