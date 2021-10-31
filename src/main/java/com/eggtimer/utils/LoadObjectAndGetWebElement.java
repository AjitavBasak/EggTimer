package com.eggtimer.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadObjectAndGetWebElement {
	
	static Properties properties;
	TestDriver testDriver = TestDriver.getInstance();
	WebDriver driver = testDriver.getDriver();
	/**
	 * Loads the property after getting the name of the file as the url navigated to with all
	 * special character replaced with '_'.
	 * running for every scenario.
	 *
	 * @param  url the url navigated to to extract the file name.
	 */
	public void loadObjectProperties(String url) {
		String name = url.replaceAll("/", "_");
		name = name.replaceAll(":", "_");
		name = name.replaceAll("\\.", "_");
		properties = new Properties();
		String fileNameConfig = System.getProperty("user.dir") + "/src/main/resources/" + name +
				".properties";
		try {
			properties.load(new FileInputStream(fileNameConfig));
		} catch (IOException io) {
			throw new RuntimeException("Property file searching for : " + fileNameConfig + "/n " + "Not" + " able " + "to find");
		}
	}
	/**
	 * gets the By object for the WebElement from the property file where locator is stored and
	 * acts as object repository
	 *
	 * @param uiObject the key in the property file to extract the object information
	 * @return By
	 */
	public By getBy(String uiObject) {
		
		String[] object = properties.getProperty(uiObject).split("::::");
		if (object.length > 2) {
			throw new RuntimeException("The regex used to seperate is present in the captured " +
					"string. Please Change it.");
		}
		String locator = object[0];
		String value = object[1];
		switch (locator.toLowerCase()) {
			case "id":
				return By.id(value);
			case "className":
				return By.className(value);
			case "cssselector":
				return By.cssSelector(value);
			case "xpath":
				return By.xpath(value);
		}
		return null;
	}
	/**
	 * gets the webElement
	 *
	 * @param object the ui element whose WebElement is to be formed to perform action on.
	 * @return WebElement
	 */
	public WebElement getFindElement(String object) {
		return driver.findElement(getBy(object));
	}
}
