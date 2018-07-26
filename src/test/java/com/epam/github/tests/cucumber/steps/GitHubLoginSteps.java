package com.epam.github.tests.cucumber.steps;

import com.epam.github.framework.core.ui.driver.Driver;
import com.epam.github.framework.core.ui.pages.CreateRepositoryPage;
import com.epam.github.framework.core.ui.pages.LoginPage;
import com.epam.github.framework.core.ui.pages.MainPage;
import com.epam.github.framework.data.UserData;
import com.epam.github.framework.utils.TestProperties;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import org.testng.Assert;

public class GitHubLoginSteps {

        private static WebDriver driver;

        static {
            try {
                driver = Driver.getWebDriverInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Given("^user navigates to github home page$")
        public void navigate_to_home_page() {
            driver.get(TestProperties.getTestProperty("login.url"));
        }

        @When("^click signIn button$")
        public void click_signIn() {
            new MainPage().open();
            new MainPage().signIn();
        }

        @And("^enters user credentials and submits login form$")
        public void enter_user_credentials() {
            new LoginPage().loginAs(new UserData());

        }

        @Then("^github repo home page is displayed$")
        public void verify_login_is_completed() {
            Assert.assertTrue(new CreateRepositoryPage().loginIsCorrect());
            System.out.println("Login was completed correctly.");
        }
}