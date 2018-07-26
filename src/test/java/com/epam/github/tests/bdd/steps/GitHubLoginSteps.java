package com.epam.github.tests.bdd.steps;

import com.epam.github.framework.core.ui.driver.Driver;
import com.epam.github.framework.utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

//        @When("^click signIn button$")
//        public void click_signIn() {
//            // Login via user-defined method
//            new (driver).openSignInPage();
//
//        }
//
//        @And("^enters user credentials and submits login form$")
//        public void enter_user_credentials() {
//            new GitHubSignInPage(driver).loginToGitHub(new User());
//
//        }
//
//        @Then("^github repo home page is displayed$")
//        public void verify_login_is_completed() {
//            Assert.assertTrue(new GitHubCreateRepoPage(driver).loginIsCorrect(), "Looks you are NOT logged in correctly!");
//            System.out.println("Login was completed correctly.");

        //}
}