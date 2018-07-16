package com.epam.github.tests.github.page;

import com.epam.github.framework.core.ui.elements.Decorator;
import com.epam.github.framework.core.ui.elements.FileElement;
import com.epam.github.framework.core.ui.pages.BasePage;
import com.epam.github.framework.utils.TestProperties;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page extends BasePage {

    @FindBy(xpath = "//tr//span/a[contains(text(), '')]")
    protected FileElement file;

    public Page() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    /**
     * Open create repository page where
     */
    public void open() {
        driver.get(TestProperties.getTestProperty("repository.url"));
    }

    public void openItem(String fileName) {
        file.selectItem(fileName);
    }

}