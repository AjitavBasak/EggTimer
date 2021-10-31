package com.eggtimer.Steps;


import com.eggtimer.pages.InitPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class InitStep {
	InitPage initPage = new InitPage();
	
	@Given("^open \"([^\"]*)\"$")
	public void open(String browser) {
		
		initPage.setBrowser(browser);
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		initPage.startTest(scenario);
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		initPage.endTest(scenario);
	}
	
	
}
