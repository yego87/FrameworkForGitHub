package com.epam.github.framework.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.epam.github.framework.data.PullsData;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PullPage {

    SelenideElement selenideElement = $(byXpath("//span[contains(@class, 'commit-ref')][2]"));

    public void fetchGitUrlAndBranch() {
        selenideElement.shouldBe(Condition.visible);

        String data = selenideElement.getText();

        String url = data.split(":")[0];
        String branch = data.split(":")[1];

        PullsData.setUrlList(url);
        PullsData.setBranch(branch);
    }

}
