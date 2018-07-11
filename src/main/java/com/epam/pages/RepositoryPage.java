package com.epam.pages;

import com.epam.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Describe Repository page
 */
public class RepositoryPage extends BasePage {

    /**
     * Web elements
     */
	@FindBy(xpath = "//strong[@itemprop='name']/a")
	private WebElement repositoryNameLink;

    /**
     * Check is new Repository was create
     * @param name
     * @return
     */
    public Boolean isRepoCreate(String name) {
        return repositoryNameLink.getText().equals(name);
    }

}
