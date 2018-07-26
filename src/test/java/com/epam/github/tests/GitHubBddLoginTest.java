package com.epam.github.tests;

import java.util.concurrent.TimeUnit;

import com.epam.github.framework.core.ui.driver.Driver;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import cucumber.api.CucumberOptions;
import org.testng.annotations.BeforeTest;

@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, tags = "@smokeTest", features = "src/test/resources/cucumber_features/github_basic.feature", glue = {
        "com.epam.github.tests.cucumber.steps.GitHubLoginSteps" })
public class GitHubBddLoginTest extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    static {
        try {
            driver = Driver.getWebDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void startBrowser() {
        // set a certain implicit wait timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Maximize browser window
        driver.manage().window().maximize();
    }

    @AfterTest
    public void stopBrowser() {
        driver.quit();
    }

}
