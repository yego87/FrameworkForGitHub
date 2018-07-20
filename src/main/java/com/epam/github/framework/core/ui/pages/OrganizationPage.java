package com.epam.github.framework.core.ui.pages;

import com.epam.github.framework.utils.TestProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Describe web page were user can create own organization
 */
public class OrganizationPage extends BasePage {

    /**
     * Web elements
     */
    @FindBy(id = "organization_login")
    private WebElement fieldOrganizationName;
    @FindBy(id = "organization_billing_email")
    private WebElement fieldOrganizationEmail;
    @FindBy (xpath = "//button[contains(text(), 'Create organization')]")
    private WebElement buttonCreateOrganization;
    @FindBy(linkText = "Finish")
    private WebElement buttonFinishCreateOrganization;
    @FindBy(linkText = "New organization")
    private WebElement buttonNewOrganization;
    @FindBy(xpath = "//*[@class='org-name lh-condensed']")
    private WebElement nameOfNewOrganization;
    @FindBy(linkText = "skip this step")
    private WebElement linkSkipSettings;
    @FindBy(linkText = "Continue")
    private WebElement buttonContinue;

    /**
     * Open web page by url
     */
    public void open() {
        driver.get(TestProperties.getTestProperty("organization.url"));
    }

    /**
     * Create organization
     * @param name
     * @param email
     */
    public void createOrganization(String name, String email) {
        type(fieldOrganizationName, name);
        type(fieldOrganizationEmail, email);
        buttonCreateOrganization.click();
        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(buttonContinue))
                .click();
        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(linkSkipSettings))
                .click();
    }

    /**
     * Check that organization was create successfully
     * @return boolean
     */
    public Boolean isOrganizationCreate(String text) {

        return getText().equals(text);
    }

    /**
     * @return String
     */
    public String getText() {
        return nameOfNewOrganization.getText();
    }

}
