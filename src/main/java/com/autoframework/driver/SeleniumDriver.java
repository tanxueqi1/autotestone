package com.autoframework.driver;

import com.autoframework.logger.LoggerController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDriver {

    public static WebDriver driver;
    final static LoggerController log=LoggerController.getLogger(SeleniumDriver.class);

    public static WebDriver open(String browser) {
        String path = System.getProperty("user.dir");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("disable-infobars");
            driver = new ChromeDriver();
        } else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", path + "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", path + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            log.error("你传入的浏览器名称有误" + browser);
        }
        return driver;
    }

    public static void closedAll() {
        driver.quit();
    }


}
