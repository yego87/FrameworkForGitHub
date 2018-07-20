package com.epam.github.framework.core.ui.pages;

import com.epam.github.framework.core.ui.elements.Decorator;
import com.epam.github.framework.core.ui.elements.FileElement;
import com.epam.github.framework.utils.TestProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Describe Repository page
 */
public class RepositoryPage extends BasePage {
    /**
     * Web elements
     */
	@FindBy(xpath = "//strong[@itemprop='name']/a")
	private WebElement repositoryNameLink;
    @FindBy(xpath = "//table[contains(@class,'files js-navigation-container js-active-navigation-container')]/tbody/tr[@class='js-navigation-item']//td[2]//span/a[contains(@href, '')]")
            // "//table[contains()@class,'js-navigation-container')]/tbody[2]/tr[@class='js-navigation-item']tr//span/a[contains(text(), '')]")
    private List<FileElement> files;

    public RepositoryPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    /**
     * Open create repository page where
     */
    public void open() {
        driver.get(TestProperties.getTestProperty("repository.url"));
    }

    public int getFilesCount(){
        return files.size();
    }

    public void openItem(int index) {
        files.get(index).click();

        //file.selectItem(fileName);
    }

    public String getItemLastCommit() {
        return "";
    }

    /**
     * Check is new Repository was create
     * @param name
     * @return
     */
    public Boolean isRepoCreate(String name) {
        return repositoryNameLink.getText().equals(name);
    }

    //core utils in all
}
