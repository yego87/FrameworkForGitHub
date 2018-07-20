package com.epam.github.framework.core.ui.pages;

import com.epam.github.framework.data.UserData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Describe authorization page
 */
public class LoginPage extends BasePage {

    /**
     * Web elements
     */
    @FindBy(id = "login_field")
    private WebElement fieldUsername;
    @FindBy(id = "password")
    private WebElement fieldPassword;
    @FindBy(name = "commit")
    private WebElement buttonSignIn;

    //instance of home page
    private HomePage homePage = new HomePage();

    /**
     * Login user in system
     * @param user
     * @return RepositoryPage
     */
    public HomePage loginAs(UserData user) {
        type(fieldUsername, user.getUsername());
        type(fieldPassword, user.getPassword());
        buttonSignIn.click();
        return homePage;
    }

    public String getText() {
        return null;
    }
}
