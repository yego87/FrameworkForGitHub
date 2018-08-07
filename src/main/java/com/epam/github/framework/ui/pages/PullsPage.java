package com.epam.github.framework.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.epam.github.framework.utils.TestProperties;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class PullsPage {

    private ElementsCollection requests = $$(byXpath("//div[@class ='border-right border-bottom border-left']//li//div/a"));

    /**
     * Check is new pull request was open
     * @return Boolean
     */
    public Boolean isNewRequestHave() {
        return !(requests == null);
    }

    public PullsPage openPage() {
        open(TestProperties.getTestProperty("pull.request.url"));

        return new PullsPage();
    }

    public List openPullPageAndGetData() {

        List parameters = new ArrayList<String>();

        for (int i = 0; i < requests.size(); ++i) {
            requests = $$(byXpath("//div[@class ='border-right border-bottom border-left']//li//div/a"));
            requests.get(i).click();
            PullPage pullPage = new PullPage();
            pullPage.fetchGitUrlAndBranch();
            back();
        }

        return parameters;
    }

}
