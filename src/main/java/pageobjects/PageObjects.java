package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
    PageObjects objects;
    @FindBy(name = "email")
    public WebElement emailField;
    @FindBy(name = "password")
    public WebElement passwordFiled;
    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[text()='Dashboard']")
    public WebElement dashboardText;
    @FindBy(xpath = "//*[@class='MuiAlert-message']")
    public WebElement alertMessage;
    @FindBy(xpath = "//*[@aria-label='completed todo']")
    public WebElement toDosList;
    @FindBy(xpath = "//*[text()='Test Cost Calculator']")
    public WebElement costCalculator;
    @FindBy(name = "name")
    public WebElement patName;
    @FindBy(name = "phone")
    public WebElement patPhone;
    public WebElement clickLink(WebDriver driver, String text){
        return driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
    }
}
