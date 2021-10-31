package com.eggtimer.utils;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {
	public static Logger Log = LogManager.getLogger(Log.class.getName());
	
	static {
		String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
		System.setProperty("logoutputpath", System.getProperty("user.dir") + "/src");
		System.setProperty("log4j.configurationFile", log4jPath);
		
	}
	
	public static void startTest(String TestCaseName) {
		Log.info("**************************************************");
		Log.info("Starting Test case : " + TestCaseName);
		Log.info("**************************************************");
	}
	
	public static void endTest(String TestCaseName) {
		Log.info("**************************************************");
		Log.info("Ending Test case : " + TestCaseName);
		Log.info("**************************************************");
	}
	
	public static void warn(String message) {
		
		Log.warn(message);
		
	}
	
	public static void error(String message) {
		
		Log.error(message);
		
	}
	
	public static void fatal(String message) {
		
		Log.fatal(message);
		
	}
	
	public static void debug(String message) {
		
		Log.debug(message);
		
	}
	
	public static void error(String message, Exception e) {
		Log.error(message, e);
	}
	
	public static void info(String message) {
		
		Log.info(message);
		
	}
}
