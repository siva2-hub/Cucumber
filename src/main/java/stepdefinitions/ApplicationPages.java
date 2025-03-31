package stepdefinitions;

import java.time.Duration;

import com.aventstack.extentreports.util.Assert;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pageobjects.PageObjects;

public class ApplicationPages {
    WebDriver driver;
    PageObjects pageObjects;
    Actions actions;
    JavascriptExecutor js;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        pageObjects = PageFactory.initElements(driver, PageObjects.class);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("driver object is null");
        }
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://gor-pathology.web.app/");
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        pageObjects.emailField.sendKeys("test@kennect.io");
        pageObjects.passwordFiled.sendKeys("Qwerty@1234");
        pageObjects.loginButton.click();
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        WebElement dashboard = driver.findElement(By.xpath("//*[text()='Dashboard']"));
        if (dashboard.isDisplayed()) {
            driver.quit();
        } else {
            System.out.println(driver.getCurrentUrl());
        }
    }

    @Then("I should see the username and password fields")
    public void iShouldSeeTheUsernameAndPasswordFields() {
        //verifying login_emain and login_password fields are displaying or not
        pageObjects.emailField.isDisplayed();
        pageObjects.passwordFiled.isDisplayed();
    }

    @Then("I should see the error validations")
    public void iShouldSeeTheErrorValidations() {
        pageObjects.alertMessage.isDisplayed();
        String text = "There is no user record corresponding to this identifier. The user may have been deleted.";
        if (pageObjects.alertMessage.getText().equals(text)) {
            System.out.println("Validations are displaying for invalid login");
        } else {
            System.out.println("Validations are not displaying");
        }
    }

    @When("I enter inValid credentials")
    public void iEnterInValidCredentials() {
        pageObjects.emailField.sendKeys("test@kennect.com");
        pageObjects.passwordFiled.sendKeys("Qwer@7238");
        pageObjects.loginButton.click();
    }

    @Then("I should see the list of todos")
    public void iShouldSeeTheListOfTodos() {
        pageObjects.toDosList.isDisplayed();
    }

    @Then("I should see the cost calculator")
    public void iShouldSeeTheCostCalculator() {
        pageObjects.costCalculator.isDisplayed();
    }

    @When("I select the Blood test")
    public void iSelectTheBloodTest() throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='TODO']")));
        Thread.sleep(1200);
        driver.findElement(By.id("patient-test")).sendKeys("bloodtest");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'bloodtest303')]")).click();
    }

    @When("I select the discount for blood test")
    public void iSelectTheDiscountForBloodTest() throws InterruptedException {
        Thread.sleep(1200);
        driver.findElement(By.xpath("//*[contains(text(),'None')]")).click();
        Thread.sleep(1200);
        //driver.findElement(By.xpath("//*[contains(text(),'15%')]")).click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }

    @Then("I should see the cost updates after applying discounts")
    public void iShouldSeeTheCostUpdatesAfterApplyingDiscounts() {
        WebElement st = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[3]/div/div[3]/div[1]/div[2]"));
        WebElement agt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[3]/div/div[3]/div[2]/div[2]"));
        String subT = st.getText().replace("₹", "").replace(" ", "");
        String actGrandTotal = agt.getText().replace("₹", "").replace(" ", "");
        int discount = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[3]/div/div[2]/div[2]/div/div")).getText().replace("%", ""));
        int subTotal = Integer.parseInt(subT);
        // Calculate the discount amount
        int disOnSubT = (subTotal * discount) / 100;
        // Calculate the grand total by subtracting the discount from the subtotal
        int expGrandTotal = subTotal - disOnSubT;
        //        System.out.println("Sub total is: " + subTotal);
        //        System.out.println("Discount is: " + discount + "%");
        //        System.out.println("Discount amount: " + disOnSubT);
        //        System.out.println("expected Grand total is: " + expGrandTotal);
//        System.out.println("actual Grand total is: " + actGrandTotal);
        if (Integer.parseInt(actGrandTotal) == expGrandTotal) {
            System.out.println(discount + "% discount applied on blood test");
        } else {
            System.out.println(discount + "% discount not applied on blood test");
        }
    }

    @When("I go to Tests Tab")
    public void iGoToTestsTab() {
        driver.findElement(By.xpath("//*[text()='Tests']")).click();
    }

    @And("I click on Add Patient Test")
    public void iClickOnAddPatientTest() {
        driver.findElement(By.xpath("//*[contains(text(),'Add Patient')]")).click();
    }

    @Then("I Should see the Patient Contact details Form")
    public void iShouldSeeThePatientContactDetailsForm() {
        pageObjects.patName.isDisplayed();
    }

    @When("I enter patient contact details")
    public void iEnterPatientContactDetails() {
        pageObjects.patName.sendKeys("Test Patient12");
        pageObjects.emailField.sendKeys("test@pt2.co");
        pageObjects.patPhone.sendKeys("7614740071");
    }

    @And("I click general details button")
    public void iClickGeneralDetailsButton() {
        driver.findElement(By.xpath("(//*[contains(text(),'General Details')])[2]")).click();
    }

    @Then("I should see the General details forn")
    public void iShouldSeeTheGeneralDetailsForn() {
        driver.findElement(By.name("height")).isDisplayed();
    }

    @When("I fill general details from")
    public void iFillGeneralDetailsFrom() {
        driver.findElement(By.name("height")).sendKeys("150");
        driver.findElement(By.name("weight")).sendKeys("60");
        actions.sendKeys(Keys.TAB).perform();
        //        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        //        driver.findElement(By.xpath("//*[contains(text(),'Gender')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Male')]")).click();
        driver.findElement(By.name("age")).sendKeys("28");
        driver.findElement(By.name("systolic")).sendKeys("90");
        driver.findElement(By.name("diastolic")).sendKeys("90");
    }

    @And("I click on Add Test")
    public void iClickOnAddTest() {
        WebElement addTests = driver.findElement(By.xpath("(//*[text()='Add Tests'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);",addTests);
        actions.moveToElement(addTests).perform();
        addTests.click();
    }

    @When("I add test")
    public void iAddTest() throws InterruptedException {
        driver.findElement(By.id("patient-test")).sendKeys("AFP");
        Thread.sleep(2000);
        pageObjects.clickLink(driver, "AFP").click();
//        driver.findElement(By.xpath("//*[contains(text(),'AFP')]")).click();
        Thread.sleep(1200);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.id("patient-tests-labs")).sendKeys("Test Lab");
        Thread.sleep(1200);
        pageObjects.clickLink(driver, "Test Lab").click();
    }

    @And("I add equipment")
    public void iAddEquipment() throws InterruptedException {
        Thread.sleep(1200);
        WebElement addEquipment = driver.findElement(By.xpath("//*[@title='Add equipment']"));
        addEquipment.click();
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[text()='check']")));
        Thread.sleep(1200);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div[2]/div/div/div/table/tbody/tr[1]/td[1]/div/div")).click();
        actions.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//*[text()='check']")).click();
    }

    @And("I click on Add Patient")
    public void iClickOnAddPatient() {
        driver.findElement(By.xpath("(//*[text()='Add Patient'])[2]")).click();
        System.exit(0);
    }
}
