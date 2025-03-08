package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import pageobjects.PageObjects;

public class ApplicationPages{
	WebDriver driver;
	PageObjects objects;
	@Given("^I open browser \"([^\"]*)\"$")
	public void i_open_browser(String arg1) throws Throwable {
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get(arg1);
	}

	@Then("^I see the Login Page$")
	public void i_see_the_Login_Page() throws Throwable {
		objects=PageFactory.initElements(driver,PageObjects.class);
		objects.signInButton.isDisplayed();
		System.out.println("Browser is Opened, Login Page is Displayed");
	}

	@When("^I enter user name \"([^\"]*)\"$")
	public void i_enter_user_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I click on Sign In button$")
	public void i_click_on_Sign_In_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("I Close the browser")
	public void i_close_the_browser() {
		driver.close();
		System.out.println("Browser is closed");
	}
}
