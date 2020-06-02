package testRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/enrolFeature",
        plugin = {"pretty", "summary"},
        strict = true, snippets = CAMELCASE,
        dryRun=false,
        glue={"stepDefinitions"},
        monochrome=true)
public class testRunner {
}
