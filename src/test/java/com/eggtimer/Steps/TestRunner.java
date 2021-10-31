package com.eggtimer.Steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"com.eggtimer.Steps"}, plugin
		= {"pretty", "json:target/cucumber-report/cucumber-report.json",
		"junit:target/surefire" + "-reports/TEST-TestSuite.xml", "html:target/cucumber-reports"},
		tags = "@Test", publish = true)

public class TestRunner {

}