package com.epam.github.framework.utils;


import com.epam.github.framework.core.driver.Driver;
import com.epam.github.framework.ui.pages.PullsPage;
import org.apache.commons.lang3.BooleanUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PullRequestChecker {

    private static PullsPage pullsPage = new PullsPage();

    public static void main(String[] args) throws Exception {
        try {
            if (BooleanUtils.isTrue(checkPullRequests())) {
                runJob();
            } else {
                System.out.println("There is now new Pull Request!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            killBrowser();
        }
    }

    private static Boolean checkPullRequests() {
        pullsPage.open();
        return pullsPage.isNewRequestHave();
    }

    private static void runJob() {
        try {
            URL url = new URL ("http://epbyminw1347:8080/job/GitHubTests/build");
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
