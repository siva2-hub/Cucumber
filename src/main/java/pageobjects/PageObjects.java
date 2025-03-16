package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
    PageObjects objects;
    @FindBy(id = "username")
    public WebElement userNameField;
    @FindBy(id = "password")
    public WebElement passwordFiled;
    @FindBy(xpath = "//*[contains(@type,'submit') and contains(text(),'Sign In')]")
    public WebElement signInButton;

}
