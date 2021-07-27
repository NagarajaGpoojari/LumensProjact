package com.Lumens.RunnerClass;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/TestCase04_Tab.feature",
					glue="com.Lumens.StepDefinitions",
					dryRun = false,
					monochrome = true,
					plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extendreport.html"})
	public class TestRunnerClass {

	}



