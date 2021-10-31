package com.eggtimer.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;


public class TestDriver {
	private static volatile TestDriver instance;
	private static Object mutex = new Object();
	protected WebDriver driver;
	
	private TestDriver() {
	}
	
	/**
	 * Singleton implementation of the DriverInitialization to have 1 instance of the class
	 * running for every scenario.
	 *
	 * @return The singleton object of DriverInitialization
	 */
	public static TestDriver getInstance() {
		TestDriver result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new TestDriver();
			}
		}
		return result;
	}
	
	/**
	 * Set the browser instance and return the Driver instance of the Browser.
	 *
	 * @param browser The selected browser from feature file example
	 * @return The browser Driver instance
	 */
	public WebDriver setBrowserInstance(String browser) {
		
		switch (browser.toLowerCase()) {
			case "chrome":
			case "google chrome":
			case "googlechrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			default:
				Log.error("Wrong browser selected: " + browser.toUpperCase() + "\n we are " +
						"supoorting" + " \n 1. chrome \n 2. firefox \n 3. edge \n 4. opera \n 5. " + "ie");
				throw new RuntimeException("Wrong browser selected: " + browser.toUpperCase() +
						"\n we are supoorting" + "\n 1. chrome \n 2. " + "firefox \n 3. edge \n 4" + "." + " opera \n 5. ie");
			
		}
		Log.info("Browser Selected  :" + browser.toUpperCase());
		return driver;
	}
	/**
	 * gives the Driver instance to all class who requires it.
	 *
	 *
	 * @return The browser Driver instance
	 */
	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * closes the browser instance after the scenario ends
	 */
	public void tearDown() {
		driver.quit();
	}
}
	

