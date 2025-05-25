package com.pages;

import com.resources.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoginPages extends OpenBrowser {
    public OpenBrowser openBrowser;
    public WebDriver driver = OpenBrowser.driver;
    public LoginPages loginPageObs;
    public Properties properties = OpenBrowser.properties;
    public WebDriverWait wait = OpenBrowser.wait;
    //Defining the Objects related to Login Page
    @FindBy(name = "username")
    public WebElement userName;
    @FindBy(name = "password")
    WebElement password;
    @FindBys(@FindBy(xpath = "//*[contains(text(),'Sign In')]"))
    List<WebElement> signInBtn;
    @FindBy(className = "user_image")
    public WebElement userProfile;
    @FindBy(xpath = "(//*[contains(@src,'vendor')])[1]")
    public WebElement companyLogo;

    public LoginPages() throws Exception {
    }

    public List<WebElement> getEleByText(WebDriver driver, String eleText) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'" + eleText + "')]"));
        return elements;
    }

    @BeforeClass
    public void loginFunction() throws Exception {
//        openBrowser = new OpenBrowser();
//        ArrayList<Object> data = openBrowser.openBrowser();
//        driver = (WebDriver) data.get(0);
//        properties = (Properties) data.get(1);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPageObs = PageFactory.initElements(driver, LoginPages.class);
        try {
            wait.until(ExpectedConditions.visibilityOf(loginPageObs.userName));
            loginPageObs.userName.sendKeys(properties.getProperty("userName"));
            Thread.sleep(1200);
            loginPageObs.password.sendKeys(properties.getProperty("pWord"));
            Thread.sleep(1300);
            loginPageObs.signInBtn.get(1).click();
            wait.until(ExpectedConditions.visibilityOf(loginPageObs.companyLogo));
        } catch (Exception e) {
        }
    }

    public boolean logout() {
        loginPageObs.userProfile.click();
        this.getEleByText(driver, "Logout").get(0).click();
        if (loginPageObs.userName.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyLogin() throws Exception {
        this.loginFunction();
        boolean result = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(loginPageObs.userProfile));
            loginPageObs.userProfile.isDisplayed();
            result = true;
        } catch (Exception e) {
            System.out.println("User Profile Image not displayed");
        }
        return result;
    }
}
