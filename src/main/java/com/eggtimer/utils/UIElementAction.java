package com.eggtimer.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIElementAction {
	LoadObjectAndGetWebElement loadObjectAndGetWebElement = new LoadObjectAndGetWebElement();
	TestDriver testDriver = TestDriver.getInstance();
	WebDriver driver = testDriver.getDriver();
	
	public void click(String object) {
		loadObjectAndGetWebElement.getFindElement(object).click();
	}
	
	public void navigate(String object) {
		loadObjectAndGetWebElement.loadObjectProperties(object);
		Log.info("Navigating to URL :" + object.toUpperCase());
		driver.navigate().to(object);
		
	}
	
	public void sendKeys(String object, String keys) {
		Log.info(keys + " keys have been sent to :" + object.toUpperCase());
		loadObjectAndGetWebElement.getFindElement(object).sendKeys(keys);
	}
	
	public String getText(String object) {
		Log.info("Text from UI Element is  :" + driver.findElement(loadObjectAndGetWebElement.getBy(object)).getText());
		return driver.findElement(loadObjectAndGetWebElement.getBy(object)).getText();
		
	}
	
	public String getTextfromAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public WebDriverWait waitTimeinSeconds(long timeInSeconds) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return w;
	}
	
	
}