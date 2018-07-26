package com.epam.github.tests;

import java.util.concurrent.TimeUnit;

import com.epam.github.framework.core.ui.driver.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;

@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, tags = "@smokeTest", features = "cucumber_features/github_basic.feature", glue = {
        "com.epam.github.tests.bdd.steps.GitHubLoginSteps" })
public class GitHubBddLoginTest extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    static {
        try {
            driver = Driver.getWebDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void startBrowser() {
        // set a certain implicit wait timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Maximize browser window
        driver.manage().window().maximize();
    }

    @After
    public void stopBrowser() {
        driver.quit();
    }

}
