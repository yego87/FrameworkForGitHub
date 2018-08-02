package com.epam.github.framework.ui.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileElement extends Element {

    @FindBy(xpath = ".//div[@id='last-commit']")
    private WebElement commit;
//    @FindBy(xpath = ".//div[@id='last-commit']")
//    private WebElement itemElement;

    public FileElement(WebElement webElement) {
        super(webElement);
    }

    public void selectItem(String itemName) {
        //itemElement.click();
    }

    public String getTimeOfCommit() {
        return commit.getText();
    }
}
