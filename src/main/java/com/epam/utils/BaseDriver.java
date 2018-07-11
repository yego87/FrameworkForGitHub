package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    private static WebDriver driver;

    private BaseDriver() {}

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(TestProperties.getWaitTime(), TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeWebBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }


}
