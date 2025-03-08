package testrunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "featurefiles/Login.feature",glue = "stepdefinitions",dryRun = false)
public class LoginTest extends AbstractTestNGCucumberTests {

}
