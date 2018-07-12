package com.epam.pages;

import com.epam.utils.TestProperties;

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
}
