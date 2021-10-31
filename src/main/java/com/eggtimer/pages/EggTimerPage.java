package com.eggtimer.pages;

import com.eggtimer.utils.UIElementAction;
import com.eggtimer.utils.VerificationsEggTimer;

public class EggTimerPage {
	UIElementAction uiElementAction = new UIElementAction();
	VerificationsEggTimer verificationsEggTimer = new VerificationsEggTimer();
	
	public void navigateToUrl(String url) {
		
		uiElementAction.navigate(url);
	}
	
	public void validatePageLoad() {
		verificationsEggTimer.validatePageLoad();
	}
	
	public void timeSendkey(String time) {
		uiElementAction.sendKeys("timeBox", time);
	}
	
	
	public void clickStart() throws InterruptedException {
		uiElementAction.click("start");
	}
	
	public void verifyAlertPresentAfterWait(String time) {
		verificationsEggTimer.verifyAlertPresentAfterWait(time);
	}
	
	public void verifyTimer(String time) {
		verificationsEggTimer.verifyTimer(time);
	}
	
}
