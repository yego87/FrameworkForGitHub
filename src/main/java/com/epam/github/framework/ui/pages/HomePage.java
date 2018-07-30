package com.epam.github.framework.ui.pages;

import com.epam.github.framework.utils.TestProperties;

/**
 * Describe home page
 */
public class HomePage extends BasePage {

    /**
     * Navigate to profile menu
     */
    public void enterProfile(){
        profileDropDown.click();
        settings.click();
    }

    /**
     * Open this page by url
     */
    public void open() {
        driver.get(TestProperties.getTestProperty("create.repository.url"));
    }

    public String getText() {
        return null;
    }
}
