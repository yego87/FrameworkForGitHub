package com.epam;

import com.epam.utils.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Describe Base page
 */
public abstract class BasePage {

    /**
     * Web elements
     */
    @FindBy(xpath = "//a[@href='/login']")
    protected WebElement signInButton;
    @FindBy(xpath = "//ul[@id = 'user-links']//li[@class='dropdown']//span[@class='dropdown-caret']")
    protected WebElement profileDropDown;
    @FindBy(xpath = "//ul[@class ='dropdown-menu dropdown-menu-sw']//li/a[contains(text(), 'Settings')]")
    protected WebElement settings;
    @FindBy(xpath = "//a[@data-selected-links=' /settings/organizations']")
    protected WebElement organization;

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait webDriverWait;

    protected BasePage() {
        driver = BaseDriver.getWebDriverInstance();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, 2);
    }

    /**
     * Write text to fields
     * @param webElement
     * @param text
     */
    protected void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

}