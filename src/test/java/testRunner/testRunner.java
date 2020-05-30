package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue={"stepDefinitions"},
        monochrome=true)
public class testRunner {
}
//E:\Year 4\SOFTENG 754\Assignment 5\SE754-Assignment-5\src\test\resources\features.loginFeature
