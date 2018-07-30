package com.epam.github.framework.ui.pages;

import com.epam.github.framework.utils.TestProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Describe Gist page
 */
public class GistPage extends BasePage {

    /**
     * Web elements
     */
    @FindBy(name = "gist[description]")
    private WebElement fieldDescription;
    @FindBy(xpath = "//div[@class='commit-create']//pre/span")
    private WebElement fieldPresentation;
    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Create secret gist')]")
    private WebElement buttonCreateSecretGist;
    @FindBy(id = "new_comment_field")
    private WebElement fieldComment;
    @FindBy(xpath = "//textarea[@id='new_comment_field']")
    private WebElement buttonAddComment;
    @FindBy(xpath = "//div[@class='repository-meta js-details-container Details']")
    private WebElement nameOfNewGist;
    @FindBy(linkText = "See all of your gists")
    private WebElement linkToAllGists;

    /**
     * Open gist page by url
     */
    public void open() {
        driver.get(TestProperties.getTestProperty("gist.url"));
    }

    /**
     * Create gist
     * @param description
     * @param presentation
     */
    public void createGist(String description, String presentation) {
        type(fieldDescription, description);
        actions.moveToElement(fieldPresentation)
                .click()
                .sendKeys(presentation)
                .perform();
        buttonCreateSecretGist.click();
    }

    /**
     * Check is gist was created
     * @param nameOfGist
     * @return boolean
     */
    public Boolean isGistCreate(String nameOfGist) {
        webDriverWait.until(ExpectedConditions.visibilityOf(nameOfNewGist));

        return getText(nameOfNewGist).equals(nameOfGist);
    }

    /**
     * Add comment to gist
     * @param comment
     */
    public void addComment(String comment) {
        webDriverWait.until(ExpectedConditions.visibilityOf(fieldComment));
        type(fieldComment, comment);
        buttonAddComment.click();
    }

    /**
     * Check is comment was added
     * @param comment
     * @return
     */
    public Boolean isCommentAdded(String comment) {

        return getText(nameOfNewGist).equals(comment);
    }

    /**
     * Return string from web element
     * @param element
     * @return
     */
    private String getText(WebElement element) {
        return element.getText();
    }

    public String getText() {
        return null;
    }
}
