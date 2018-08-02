package com.epam.github.framework.ui.pages;

import com.epam.github.framework.utils.TestProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PullsPage extends BasePage {

    @FindBy(xpath = "//li[contains(@id, 'issue')]")
    private List<WebElement> requests;


    /**
     * Open create repository page
     */
    public void open() {
        driver.get(TestProperties.getTestProperty("pull.request.url"));
    }

    /**
     * Check is new pull request was open
     * @return Boolean
     */
    public Boolean isNewRequestHave() {
        return !(requests == null);
    }

//    public PullsPage() {
//        PageFactory.initElements(new Decorator(driver), this);
//    }
}
