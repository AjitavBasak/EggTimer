package com.eggtimer.pages;

import com.eggtimer.utils.Log;
import com.eggtimer.utils.TestDriver;
import io.cucumber.java.Scenario;

public class InitPage {
	TestDriver testDriver;
	
	public void setBrowser(String browser) {
		testDriver.setBrowserInstance(browser);
	}
	
	
	public void endTest(Scenario scenario) {
		TestDriver.getInstance().tearDown();
		Log.endTest(scenario.getName());
	}
	
	public void startTest(Scenario scenario) {
		testDriver = TestDriver.getInstance();
		Log.startTest(scenario.getName());
	}
}
