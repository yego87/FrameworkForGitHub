package com.epam.github.framework.core.runner;

import com.epam.github.framework.core.driver.Driver;
import com.epam.github.framework.data.PullsData;
import com.epam.github.framework.ui.pages.PullsPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.BooleanUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JenkinsRunner {

    private static PullsPage pullsPage = new PullsPage();
    private static List<Object> body = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try {
            if (BooleanUtils.isTrue(checkPullRequestsFromUi() == checkPullRequestsFromAPI())) {
                pullsPage.openPullPageAndGetData();
                for (int i = 0; i < PullsData.getUrlList().size(); ++i) {
                    runJob(PullsData.getUrlList().get(i), PullsData.getBranch().get(i));
                }
                    System.out.println("There is new Pull Request! Job start!");
            } else {
                System.out.println("There is no new Pull Request!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            killBrowser();
        }
    }

    private static boolean checkPullRequestsFromUi() {
        pullsPage.openPage();
        return pullsPage.isNewRequestHave();
    }

    private static boolean checkPullRequestsFromAPI() {
        Response response = RestAssured.get("https://api.github.com/repos/yego87/FrameworkForGitHub/pulls");
        body = response.jsonPath().getList("url");
        return !body.isEmpty();
    }

    private static int count() {
        return body.size();
    }

    private static void runJob(String name, String branch) {
        try {
            URL url = new URL ("http://epbyminw1347:8080/job/GitHubTests/buildWithParameters?git_url=https://github.com/"
                    + name +"/FrameworkForGitHub.git&branch="
                    + branch
            );

            String user = "yegor_veselov";
            String pass = "11e2df3cc4ce2db63a8b8a48150cadc1";
            String authStr = user +":"+  pass;
            String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("utf-8"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void killBrowser() throws Exception {
        Driver.killBrowser();
    }
}
