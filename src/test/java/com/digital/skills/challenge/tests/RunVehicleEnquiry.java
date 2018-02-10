package com.digital.skills.challenge.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue = "com.digital.skills.challenge.tests.steps",
        format = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"})
public class RunVehicleEnquiry {
}
