package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "featurefiles/OpenApp.feature",glue = "stepdefinitions",dryRun = false)
public class OpenAppTest extends AbstractTestNGCucumberTests {
}
