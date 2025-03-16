package stepdefinitions;

import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
	@Before
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		objects=PageFactory.initElements(driver,PageObjects.class);
		driver.get("https://staging-portal.iidm.com");
		System.out.println("Browser is Opened, Login Page is Displayed");
	}
	@Then("^I see the Login Page$")
	public void i_see_the_Login_Page() throws Throwable {
		objects.signInButton.isDisplayed();
		System.out.println("Sign in button is enabled");
	}
	@When("I enter valid data {string},{string} and click sign-in")
	public void iEnterValidDataAndClickSignIn(String userName, String pWord) throws Exception {
		objects.userNameField.sendKeys(userName);
		objects.passwordFiled.sendKeys(pWord);
		Thread.sleep(2000);
		objects.signInButton.click();
	}
	@Then("I should see the username")
	public void iShouldSeeTheUsername() {
	}
	@When("I click on logout")
	public void iClickOnLogout() {
	}

//	@After
	public void tearDown() {
		if (driver!=null){
			driver.quit();
			System.out.println("Browser is closed");
		}else {
			System.out.println("WebDriver object is null");
		}
	}
}
