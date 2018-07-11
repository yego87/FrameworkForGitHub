package com.epam.pages;

import com.epam.BasePage;
import com.epam.utils.TestProperties;

/**
 * Describe Main page
 */
public class MainPage extends BasePage {

    private LoginPage loginPage = new LoginPage();

    /**
     * Navigate to login page
     * @return loginPage
     */
    public LoginPage signIn() {
        signInButton.click();

        return loginPage;
    }

    public void open() {
        driver.get(TestProperties.getTestProperty("main.url"));
    }

}
