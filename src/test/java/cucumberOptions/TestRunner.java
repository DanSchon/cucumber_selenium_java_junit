package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( // maps the features to the step definitions
		features = "src/test/java/features",
		glue = "stepDefinitions",
		tags = "@automated") 
public class TestRunner {

}
