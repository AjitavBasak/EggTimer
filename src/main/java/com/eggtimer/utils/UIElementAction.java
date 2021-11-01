package com.eggtimer.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIElementAction {
	LoadObjectAndGetWebElement loadObjectAndGetWebElement = new LoadObjectAndGetWebElement();
	TestDriver testDriver = TestDriver.getInstance();
	WebDriver driver = testDriver.getDriver();
	
	/**
	 * wrapper method for WebElement.click()
	 *
	 * @param object The element on which it needs to click
	 */
	public void click(String object) {
		loadObjectAndGetWebElement.getFindElement(object).click();
	}
	
	/**
	 * wrapper method for driver.navigate.to(URL)
	 *
	 * @param object The url where it needs to naviagate to
	 */
	public void navigate(String object) {
		loadObjectAndGetWebElement.loadObjectProperties(object);
		Log.info("Navigating to URL :" + object.toUpperCase());
		driver.navigate().to(object);
		
	}
	
	/**
	 * wrapper method for WebElement.sendKeys(keys)
	 *
	 * @param object The element where keys have to be sent
	 * @param keys   the character sequence where keys has to be sent.
	 */
	public void sendKeys(String object, String keys) {
		Log.info(keys + " keys have been sent to :" + object.toUpperCase());
		loadObjectAndGetWebElement.getFindElement(object).sendKeys(keys);
	}
	
	/**
	 * wrapper method for WebElement.getText()
	 *
	 * @param object The element where text has to be captured
	 * @return the text captured
	 */
	public String getText(String object) {
		Log.info("Text from UI Element is  :" + driver.findElement(loadObjectAndGetWebElement.getBy(object)).getText());
		return driver.findElement(loadObjectAndGetWebElement.getBy(object)).getText();
		
	}
	
	/**
	 * wrapper method for getting text from Alert class
	 *
	 * @return the text captured from Alert box
	 */
	public String getTextfromAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	/**
	 * wrapper method for wait method
	 *
	 * @param timeInSeconds duration to wait till
	 * @return WebDriverWait object
	 */
	public WebDriverWait waitTimeinSeconds(long timeInSeconds) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return w;
	}
	
	
}