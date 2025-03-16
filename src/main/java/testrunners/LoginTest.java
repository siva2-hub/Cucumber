package testrunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "featurefiles/Login.feature",glue = "stepdefinitions",dryRun = false,
plugin = {"pretty","html:target/loginReport.html"})

public class LoginTest extends AbstractTestNGCucumberTests {

}
