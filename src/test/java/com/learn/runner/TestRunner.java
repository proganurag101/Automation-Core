package com.learn.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Path to your .feature files
    glue = "com.learn.StepDefinitions",      // Path to your step definition package
    plugin = {"pretty", "html:target/cucumber-reports/report.html"}, // Optional: for reporting
    monochrome = true // Optional: makes console output more readable
)
public class TestRunner {
    // This class remains empty, it's just a holder for the annotations
}
