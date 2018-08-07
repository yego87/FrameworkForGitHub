package com.epam.github.framework.data;

import java.util.ArrayList;
import java.util.List;

public class PullsData {

    private static List<String> urlList = new ArrayList<>();
    private static List<String> branchList = new ArrayList<>();


    public static void setUrlList(String url) {
        urlList.add(url);
    }

    public static void setBranch(String branch) {
        branchList.add(branch);
    }

    public static List<String> getUrlList() {
        return urlList;
    }

    public static List<String> getBranch() {
        return branchList;
    }
}
