package com.epam.github.framework.core.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileElement extends Element {

    public FileElement(WebElement webElement) {
        super(webElement);
    }

    public void selectItem(String itemName) {
        webElement.findElement(By.xpath("//tr//span/a[contains(text(), '" + itemName + "')]")).click();
    }

    public String getTimeOfCommit() {
        return webElement.findElement(By.xpath("//div//relative-time")).getText();
    }
}
