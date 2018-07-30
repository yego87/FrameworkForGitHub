package com.epam.github.framework.ui.elements;

import org.openqa.selenium.*;

public class Element {

    /**
     * Selenium's WebElement
     */
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }


    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#click()
     */
    public void click() {
        webElement.click();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#submit()
     */
    public void submit() {
        webElement.submit();

    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#sendKeys(java.lang.CharSequence[])
     */
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);

    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#clear()
     */
    public void clear() {
        webElement.clear();

    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#getTagName()
     */
    public String getTagName() {
        return webElement.getTagName();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#getAttribute(java.lang.String)
     */
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#isSelected()
     */
    public boolean isSelected() {
        return webElement.isSelected();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#isEnabled()
     */
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#getText()
     */
    public String getText() {
        return webElement.getText();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#findElement(org.openqa.selenium.By)
     */
    public Element findElement(By by) {
        return new Element(webElement.findElement(by));
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#getCssValue(java.lang.String)
     */
    public String getCssValue(String arg0) {
        return webElement.getCssValue(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#getLocation()
     */
    public Point getLocation() {
        return webElement.getLocation();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#getSize()
     */
    public Dimension getSize() {
        return webElement.getSize();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openqa.selenium.WebElement#isDisplayed()
     */
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public boolean isElementPresent() {
        try {
            isElementAvailable();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementAvailable() {
        return webElement.isEnabled();
    }

}
