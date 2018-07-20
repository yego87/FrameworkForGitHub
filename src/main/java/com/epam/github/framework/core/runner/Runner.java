package com.epam.github.framework.core.runner;

import java.io.File;
import java.util.List;

import com.epam.github.framework.common.config.Settings;
import com.epam.github.framework.common.config.TestNgConfig;
import com.epam.github.framework.core.ui.driver.Driver;
import com.epam.github.framework.core.ui.driver.WebDriverTypes;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {

	protected TestNG testNG = new TestNG();

	@SuppressWarnings("rawtypes")
	protected List<Class> listeners;

	public static void main(String[] args) {
		try {
			new Runner(args).run();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public Runner(String[] args) {
		Settings settings = new Settings();
		CmdLineParser parser = new CmdLineParser(settings);
		try {
			parser.parseArgument(args);
			TestNgConfig.addTestngConfig(settings.pathToTestng);
			Driver.setDefaultWebDriverType(WebDriverTypes.valueOf(settings.driver));

		} catch (CmdLineException e) {
			parser.printUsage(System.out);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void run() throws Exception {
		try {
			List includedGroups = TestNgConfig.getIncludedGroups();
			List excludedGroups = TestNgConfig.getExcludedGroups();

			for (String suite : TestNgConfig.getTestngConfigs()) {
				for (XmlSuite xmlSuite : new Parser(suite).parseToList()) {
					for (XmlTest test : xmlSuite.getTests()) {
						test.getIncludedGroups().addAll(includedGroups);
						test.getExcludedGroups().addAll(excludedGroups);
					}
					this.testNG.setCommandLineSuite(xmlSuite);
				}
			}
			this.testNG.run();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			Driver.getWebDriverInstance().quit();
		}
	}

}
