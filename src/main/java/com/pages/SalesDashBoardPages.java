package com.pages;

import com.resources.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SalesDashBoardPages extends OpenBrowser {

    public SalesDashBoardPages sales;
    public LoginPages loginPages;
    //Storing WebElements
    @FindBy(className = "arrow")
    public WebElement branchFilter;
    @FindBys(value = @FindBy(xpath = "//*[@class='tree-select-dropdown']/div/div"))
    public List<WebElement> branchesList;
    @FindBys(value = @FindBy(xpath = "//*[@class='tree-select-dropdown']/div/div/div[2]/div"))
    public List<WebElement> branchesUsersList;

    public void navigateToSalesDashBoard() throws Exception {
        sales = PageFactory.initElements(driver, SalesDashBoardPages.class);
        loginPages = new LoginPages();
        loginPages.getElementByText(driver, "Dashboard").click();
        loginPages.getElementByText(driver, "Sales").click();
        Thread.sleep(4000);
    }

    public boolean checkSalesManagerInOwnBranch(String branchName, String salesManager, boolean checkOnlyBranch) throws Exception {
        this.navigateToSalesDashBoard();
        boolean checkUser = false;
        sales.branchFilter.isDisplayed();
        sales.branchFilter.click();
        Thread.sleep(4300);
        int branchesCount = sales.branchesList.size();
        ArrayList<String> branchList = new ArrayList<>();
        for (WebElement branch : sales.branchesList) {
            branchList.add(branch.getText());
        }
        System.out.println("Branches count: " + branchesCount + "\nBranches List: " + branchList);
        for (WebElement branch : sales.branchesList) {
            if (branch.getText().equals(branchName)) {
                if(checkOnlyBranch){
                    branch.click();
                    branch.findElement(By.xpath("//div/input")).click();Thread.sleep(4300);
                    checkUser = true; break;
                }else {
                    branch.click();
                    for (WebElement salesEle : sales.branchesUsersList) {
                        if (salesEle.getText().equals(salesManager)) {
                            salesEle.click(); Thread.sleep(4300); checkUser = true; break;
                        }
                    }
                }
                break;
            }
        }if (checkUser){
            System.out.println(salesManager+" is found in branches dropdown");
        }else {
            System.out.println(salesManager+" isn't found in branches dropdown");
        }
        return checkUser;
    }
    public void checkGoalsForDifferentSales() throws Exception {
        this.navigateToSalesDashBoard();
        loginPages.getEleByText(loginPages.driver,"Admin").get(0).click();
        loginPages.wait.until(ExpectedConditions.visibilityOf(loginPages.getEleByText(driver,"Users").get(0)));
        loginPages.getEleByText(driver,"Users").get(0).click();
        loginPages.wait.until(ExpectedConditions.visibilityOf(loginPages.getEleByText(driver,"User Profile").get(0)));
        Thread.sleep(2300);
    }
}
