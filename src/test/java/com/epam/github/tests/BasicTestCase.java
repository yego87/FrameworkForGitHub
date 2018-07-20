package com.epam.github.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * Basic abstract class for all tests
 */
public abstract class BasicTestCase {

    @BeforeSuite(alwaysRun = true)
    public void setUpBeforeSuite() throws Exception {
    }

    @BeforeClass(alwaysRun = true)
    public void setUpBeforeClass() throws Exception {
    }

}