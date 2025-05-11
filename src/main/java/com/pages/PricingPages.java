package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PricingPages {
    private static final Logger log = LoggerFactory.getLogger(PricingPages.class);
    public LoginPages loginPages;
    public PricingPages pricingPages;
    public Actions actions;

    //Defining Objects
    @FindBy(xpath = "(//*[contains(@src,'edit')])[1]")
    public WebElement editIcon;
    @FindBy(name = "stock_code")
    public WebElement stockCodeInput;
    @FindBy(name = "list_price")
    WebElement listPriceInput;
    @FindBy(name = "description")
    WebElement descInput;


    public void navigateToPricing() throws Exception {
        loginPages = new LoginPages();
        loginPages.verifyLogin();
        loginPages.getEleByText(loginPages.driver,"Pricing").get(0).click();
        loginPages.getEleByText(loginPages.driver,"Pricing").get(1).click();
        pricingPages = PageFactory.initElements(loginPages.driver, PricingPages.class);
        loginPages.wait.until(ExpectedConditions.visibilityOf(pricingPages.editIcon));
    }
    public void addProduct(String stockCode, String discountCode,double listPrice, String productClass) throws Exception {
        this.navigateToPricing();
        loginPages.getEleByText(loginPages.driver,"Add").get(0).click();
        loginPages.wait.until(ExpectedConditions.visibilityOf(pricingPages.stockCodeInput));
        pricingPages.stockCodeInput.sendKeys(stockCode);
        loginPages.getEleByText(loginPages.driver,"Select").get(0).click();
        Thread.sleep(1200);
        this.selectDropddown(discountCode);
        Thread.sleep(1200);
        pricingPages.listPriceInput.sendKeys(String.valueOf(listPrice));
        loginPages.getEleByText(loginPages.driver,"Select").get(0).click();
        actions = new Actions(loginPages.driver);
        actions.sendKeys(productClass).perform();
        actions.sendKeys(Keys.ENTER).perform();
        pricingPages.descInput.sendKeys("Manually added through script");
    }
    public void selectDropddown(String value){
        List<WebElement> dd = loginPages.driver.findElements(By.xpath("//*[contains(@class,'css-4mp3pp')]"));
        for (int i = 0; i < dd.size(); i++) {
            System.out.println(dd.get(i).findElement(By.tagName("div")).getText());
            if(dd.get(i).findElement(By.tagName("div")).getText().equals(value)){
                dd.get(i).findElement(By.tagName("div")).click();
                break;
            }else {}
        }
    }
}
