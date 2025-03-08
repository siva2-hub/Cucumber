package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "featurefiles/OpenApp.feature",glue = "stepdefinitions",dryRun = true)
public class OpenAppTest extends AbstractTestNGCucumberTests {
}
