package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "summary"},
        strict = true, snippets = CAMELCASE,
        dryRun=true,
        glue={"stepDefinitions"},
        monochrome=true)
public class testRunner {
}
