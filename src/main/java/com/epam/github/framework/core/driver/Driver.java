package com.epam.github.framework.core.driver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.epam.github.framework.core.common.exception.UnknownDriverTypeException;


public class Driver {

	private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";

	private static WebDriverTypes defaultDriverType = WebDriverTypes.CHROME;

	private static HashMap<String, org.openqa.selenium.WebDriver> instances;

	static {
		instances = new HashMap<String, WebDriver>();
	}

	public static WebDriver getWebDriverInstance(String name, WebDriverTypes type) {
		WebDriver driver;
		if (!instances.containsKey(name)) {
			switch (type) {
			case FIREFOX: {
				driver = new FirefoxDriver();
				break;
			}
			case IE: {
				System.setProperty("webdriver.ie.driver", "");
				driver = new InternetExplorerDriver();
				break;
			}
			case CHROME: {
				System.setProperty("webdriver.chrome.driver",  "D:\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
			default:
				throw new UnknownDriverTypeException("Unknown web driver specified: " + type);
			}
			try {
				driver.manage().window().maximize();
			}catch (ExceptionInInitializerError e) {
			e.getCause();
			}
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//TestProperties.getWaitTime(), TimeUnit.SECONDS);

			instances.put(name, driver);
		} else {
			driver = instances.get(name);
		}
		return driver;
	}

	public static WebDriver getWebDriverInstance(String name) throws Exception {
		return getWebDriverInstance(name, defaultDriverType);
	}

	public static WebDriver getWebDriverInstance() throws Exception {
		return getWebDriverInstance(DEFAULT_WEB_DRIVER, defaultDriverType);
	}

	public static void setDefaultWebDriverType(WebDriverTypes type) {
		defaultDriverType = type;
	}

	public static void killBrowser() throws Exception {
		getWebDriverInstance().quit();
	}
}
