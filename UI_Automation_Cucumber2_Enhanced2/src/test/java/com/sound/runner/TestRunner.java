package com.sound.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue="com.sound.step_defnitions",
		dryRun=false,
		monochrome=true,
		plugin= {"rerun:target/failed_scenario.txt","pretty","html:target/cucumber.reports/report.html"},
		publish=true
		)
public class TestRunner {

}
