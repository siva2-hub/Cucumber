package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
    PageObjects objects;
    @FindBy(id = "")
    WebElement userNameField;
    @FindBy(id = "")
    WebElement passwordFiled;
    @FindBy(xpath = "//*[contains(@type,'submit') and contains(text(),'Sign In')]")
    public WebElement signInButton;

}
