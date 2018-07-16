package com.epam.github.tests.github.page;

import com.epam.github.framework.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Describe organization page
 */
public class ProfilePage extends BasePage {

    /**
     * Web elements
     */
    @FindBy(id = "user_profile_name")
    private WebElement fieldName;
    @FindBy(xpath = "//form[@data-alambic-owner-type='User']//button[@type='submit']")
    private WebElement updateProfileButton;
    @FindBy(linkText = "view your profile.")
    private WebElement linkToProfile;
    @FindBy(xpath = "//span[@itemprop='name']")
    private WebElement profileName;

    /**
     * Edit name in profile settings
     * @param name
     */
    public void editName(String name) {
        type(fieldName, name);
        updateProfileButton.click();
        linkToProfile.click();
    }

    /**
     * Check is profile was edit
     * @param text
     * @return Boolean
     */
    public Boolean isProfileEdit(String text) {
        return getText().equals(text);
    }

    /**
     * @return String
     */
    public String getText() {
        return profileName.getText();
    }

}
