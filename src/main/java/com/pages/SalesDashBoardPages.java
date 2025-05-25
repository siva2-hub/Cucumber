package com.pages;

import com.resources.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalesDashBoardPages extends OpenBrowser {

    public SalesDashBoardPages sales;
    public LoginPages loginPages;
    //Storing WebElements
    @FindBy(className = "arrow")
    public WebElement branchFilter;
    @FindBys(value = @FindBy(xpath = "//*[@class='tree-select-dropdown']/div/div"))
    public List<WebElement> branchesList;

    public void navigateToSalesDashBoard() throws Exception {
        sales = PageFactory.initElements(driver, SalesDashBoardPages.class);
        loginPages = new LoginPages();
        loginPages.getElementByText(driver, "Dashboard").click();
        loginPages.getElementByText(driver, "Sales").click();
        Thread.sleep(4000);
    }

    public void checkSalesManagerInOwnBranch(String branchName, String salesManager) throws Exception {
        this.navigateToSalesDashBoard();
        sales.branchFilter.isDisplayed();
        sales.branchFilter.click();
        Thread.sleep(4300);
        int branchesCount = sales.branchesList.size();
        System.out.println("branches count is " + branchesCount + "\nList of first are ");
        for (int i = 0; i < branchesCount; i++) {
            WebElement branch = sales.branchesList.get(i);
            System.out.println("List of branches are " + branch.getText());
            if (branch.getText().equals(branchName)) {
                branch.click();
                break;
            }
        }

        System.exit(0);
    }
}
