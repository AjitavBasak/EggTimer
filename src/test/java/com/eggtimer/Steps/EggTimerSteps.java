package com.eggtimer.Steps;

import com.eggtimer.pages.EggTimerPage;
import com.eggtimer.utils.PropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EggTimerSteps {
	
	EggTimerPage eggTimerPage = new EggTimerPage();
	
	@Given("Read url from property file and navigate")
	public void read_url_from_property_file_and_navigate() {
		PropertyReader propertyReader = new PropertyReader();
		// Write code here that turns the phrase above into concrete actions
		String url = PropertyReader.readItem("url");
		eggTimerPage.navigateToUrl(url);
		
	}
	
	@Then("User validate page gets loaded")
	public void user_validate_page_gets_loaded() {
		// Write code here that turns the phrase above into concrete actions
		eggTimerPage.validatePageLoad();
	}
	
	@When("^User enters \"([^\"]*)\" in the website$")
	public void User_enters_time_in_the_website(String time) {
		eggTimerPage.timeSendkey(time);
		
	}
	
	@And("User clicks on start")
	public void User_clicks_on_start() throws InterruptedException {
		eggTimerPage.clickStart();
	}
	
	@Then("^User verifies if timer is reduced by 1 sec for \"([^\"]*)\"$")
	public void User_verifies_if_timer_is_reduced_by_1_sec(String time) {
		eggTimerPage.verifyTimer(time);
	}
	
	@And("^User verifies if alert is present after \"([^\"]*)\"$")
	public void user_verifies_if_alert_is_present_after_something(String time) throws Throwable {
		eggTimerPage.verifyAlertPresentAfterWait(time);
	}
}
