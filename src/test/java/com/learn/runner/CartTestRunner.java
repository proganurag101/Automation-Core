package com.learn.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.learn.StepDefinitions","com.learn.hooks"},
        tags = "@Cart or @backgroundTest",
        plugin = {"pretty","html:target/cucumber-reports.html"}

)
public class CartTestRunner {

}
