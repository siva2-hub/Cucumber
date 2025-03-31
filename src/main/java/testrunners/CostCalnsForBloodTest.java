package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "featurefiles/CostCalsBloodTest.feature",glue = "stepdefinitions",dryRun = false,
        plugin = {"pretty","html:target/loginReport.html"})
public class CostCalnsForBloodTest extends AbstractTestNGCucumberTests {
}
