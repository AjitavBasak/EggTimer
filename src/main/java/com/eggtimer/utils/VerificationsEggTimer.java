package com.eggtimer.utils;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerificationsEggTimer {
	UIElementAction uiElementAction = new UIElementAction();
	/**
	 * To verify the Alert box is present or not after the time has elapsed
	 *
	 * @param time the time set after which the alert box saying time expired should appear.
	 */
	public void verifyAlertPresentAfterWait(String time) {
		String pageLoadTimeVariableinSecond = PropertyReader.readItem(
				"pageLoadTimeVariableinSecond");
		time = time.replaceAll("\\D+", "");
		long start = System.currentTimeMillis();
		Long timeinSeconds = Long.parseLong(time);
		long additionalPageLoadTime = Long.parseLong(pageLoadTimeVariableinSecond);
		timeinSeconds += additionalPageLoadTime;
		WebDriverWait w = uiElementAction.waitTimeinSeconds(timeinSeconds);
		Log.info("The Alert box is present: " + (w.until(ExpectedConditions.alertIsPresent()) != null));
		Assert.assertTrue(w.until(ExpectedConditions.alertIsPresent()) != null);
	}
	/**
	 * To verify the page is loaded successfully
	 *
	 */
	public void validatePageLoad() {
		JavascriptExecutor js;
		js = (JavascriptExecutor) uiElementAction.driver;
		boolean assertion =
				js.executeScript("return document.readyState").equals("complete") == true;
		Log.info("The page loaded successfully: " + assertion);
		Assert.assertTrue("The page loaded successfully: " + assertion, assertion);
	}
	/**
	 * To verify the timer reduces every Second
	 *
	 * @param  time The time for which the timer runs and validation happens
	 */
	public void verifyTimer(String time) {
		time = time.replaceAll("\\D+", "");

		Long timeinSeconds = Long.parseLong(time);
		int counter = 0;
		boolean assertion = true;
		for (long reducingTimeCounter = timeinSeconds-1; reducingTimeCounter >0; reducingTimeCounter--) {
			if (counter == 3) {
				Assert.fail("The Timer is not proper. Does not decrease every second");
			}
			WebDriverWait w = uiElementAction.waitTimeinSeconds(1);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			String text = uiElementAction.getText("timer");
			String timeReduced = Long.toString(reducingTimeCounter);
			assertion = text.contains(timeReduced);
			if (!assertion) {
				Log.info("Assertion of timer failed for " + timeReduced);
				counter++;
			}
			if(counter!=3){
				assertion = true;
			}
		}
		Log.info("The refresh happens properly: " + assertion);
		Assert.assertTrue("The refresh happens properly: " + assertion, assertion);
	}
	
	/**
	 * To verify the Alert box message is proper
	 *
	 * @param  message text captured from Alert box
	 */
	public void verifyAlertText(String message){
		boolean assertion=message.equals(uiElementAction.getTextfromAlert());
		Log.info("Alert message is correct : "+ assertion);
		Assert.assertTrue("Alert message is correct : "+ assertion,assertion);
	}
}
