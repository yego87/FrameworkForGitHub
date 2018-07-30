package com.epam.github.framework.reports;
import com.epam.github.framework.utils.TestProperties;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TestListners implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {
        Reporter.setCurrentTestResult(iTestResult);
        File outputDirectory = new File(TestProperties.getTestProperty("test.screenshot.path"));
        try {
            outputDirectory.mkdirs();
            File outFile = new File(outputDirectory, "TEST-" + iTestResult.getName() + ".png");
            captureScreenshots(outFile);
            Reporter.log("<a href='" + outFile.getName() + "'>screenshot</a>");
        } catch (Exception e) {
            Reporter.log("Couldn't create screenshot");
            Reporter.log(e.getMessage());
        }
        Reporter.setCurrentTestResult(null);
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }


    private static void captureScreenshots(File outFile) throws Exception {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", outFile);
    }
}