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
    @FindBy(xpath = "//*[@placeholder='Enter Description']")
    WebElement descInput;
    @FindBy(xpath = "//span[text()='Add Product']")
    WebElement addProductButton;
    @FindBy(xpath = "//*[@title='close']")
    WebElement pageClose;


    public void navigateToPricing() throws Exception {
        loginPages = new LoginPages();
        loginPages.verifyLogin();
        loginPages.getEleByText(loginPages.driver, "Pricing").get(0).click();
        loginPages.getEleByText(loginPages.driver, "Pricing").get(1).click();
        pricingPages = PageFactory.initElements(loginPages.driver, PricingPages.class);
        loginPages.wait.until(ExpectedConditions.visibilityOf(pricingPages.editIcon));
    }

    public void addProduct(String stockCode, String discountCode, double listPrice, String productClass) throws Exception {
        this.navigateToPricing();
        actions = new Actions(loginPages.driver);
        loginPages.getEleByText(loginPages.driver, "Add").get(0).click();
        loginPages.wait.until(ExpectedConditions.visibilityOf(pricingPages.stockCodeInput));
        //Fill the stock code
        pricingPages.stockCodeInput.sendKeys(stockCode);
        //Select the Discount code
        loginPages.getEleByText(loginPages.driver, "Select").get(0).click();
        actions.sendKeys(discountCode).perform();
        this.selectDropddown(discountCode);
        //Fill the list price
        pricingPages.listPriceInput.sendKeys(String.valueOf(listPrice));
        //Select Product class
        loginPages.getEleByText(loginPages.driver, "Select").get(0).click();
        actions.sendKeys(productClass).perform();
        this.selectDropddown(productClass);
        //Fill the Description Field
        pricingPages.descInput.sendKeys("Manually added through script");
        //click on Add Product button
        pricingPages.addProductButton.click();
    }

    public boolean addProduct_EmptyStockCode(Object[] vals) throws Exception {
        String stockCode = vals[0].toString();
        String discountCode = vals[1].toString();
        String listPrice = vals[2].toString();
        String productClass = vals[3].toString();
        String validation = vals[4].toString();
        this.addProduct(stockCode, discountCode, Double.parseDouble(listPrice), productClass);
        boolean result = false;
        try {
            loginPages.getEleByText(loginPages.driver, validation).get(0).isDisplayed();
            Thread.sleep(1200);
            result = true;
        } catch (Exception e) {
        }
        pricingPages.pageClose.click();
        return result;
    }

    public void selectDropddown(String value) {
        List<WebElement> dd = loginPages.driver.findElements(By.xpath("//*[contains(@class,'css-4mp3pp')]"));
        for (int i = 0; i < dd.size(); i++) {
            //System.out.println(dd.get(i).findElement(By.tagName("div")).getText());
            if (dd.get(i).findElement(By.tagName("div")).getText().contains(value)) {
                dd.get(i).findElement(By.tagName("div")).click();
                break;
            } else {
            }
        }
    }
}
