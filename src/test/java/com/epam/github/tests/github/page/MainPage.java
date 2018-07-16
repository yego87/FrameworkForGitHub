package com.epam.github.tests.github.page;

import com.epam.github.framework.core.ui.pages.BasePage;
import com.epam.github.framework.utils.TestProperties;

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

    public String getText() {
        return null;
    }
}
