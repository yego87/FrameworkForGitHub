package com.epam.github.framework.core.ui.pages;


import com.epam.github.framework.utils.TestProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Describe create repository page
 */
public class CreateRepositoryPage extends BasePage {

    /**
     * Web elements
     */
    @FindBy(id = "repository_name")
    private WebElement fieldName;
    @FindBy (xpath = "//div[@id='your_repos']//h3[contains(.,'Your repositories')]")
    private WebElement yourRepositoriesLabel;
    @FindBy(xpath = "//form[@id='new_repository']//button[@type='submit']")
    private WebElement buttonCreateRepo;

    //Instance of Repository page
    RepositoryPage repositoryPage = new RepositoryPage();

    /**
     * Open create repository page where
     */
    public void open() {
        driver.get(TestProperties.getTestProperty("create.repository.url"));
    }

    /**
     * Create new repository
     * @param text
     * @return
     */
    public RepositoryPage createRepo(String text) {
        type(fieldName, text);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonCreateRepo))
                .click();

        return repositoryPage;
    }

    public boolean loginIsCorrect() {
        return yourRepositoriesLabel.isDisplayed();

    }

    public String getText() {
        return null;
    }
}
