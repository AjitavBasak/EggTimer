package com.eggtimer.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	static Properties properties;
	
	public PropertyReader() {
		loadConfigProperties();
	}
	
	public static String readItem(String propertyName) {
		return properties.getProperty(propertyName);
	}
	
	public void loadConfigProperties() {
		properties = new Properties();
		String fileNameConfig = System.getProperty("user.dir") + "/src/main/resources" +
				"/eggTimerConfig" + ".properties";
		try {
			properties.load(new FileInputStream(fileNameConfig));
		} catch (IOException io) {
			throw new RuntimeException("Property file searching for : " + fileNameConfig + "/n " + "Not" + " able " + "to find");
		}
	}
}
