package com.tests;

import com.pages.LoginPages;
import com.pages.PricingPages;
import com.resources.OpenBrowser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PricingTests extends OpenBrowser {
    public PricingPages pricingPages;

    @DataProvider(name = "productDetails")
    public Object[][] productDetails() {
        return new Object[][]{
                {"", "BACO44", "342.21", "BA01", "Please enter Stock Code"},
                {"0165019NS", "BACO44", "342.21", "BA01", "The Stock Code already exists."},
                {"0165123", "BACO44", "", "BA01", "Please enter List Price"},
                {"0165123", "BACO44", "0", "BA01", "Price cannot be zero"},
                {"0165123", "BACO44", "jgjhgj", "BA01", "Please enter valid number"},
                {"0165123", "BACO44", "190.23", "", "Please select Product Class"},
                {"0165123", "", "190.23", "BA01", "Please select Discount Code"}
        };
    }
    @Parameters({"stockCode", "discountCode", "listPrice", "productClass", "validation"})
    @Test(dataProvider = "productDetails")
    public void addProductTest_EmptyStockCode(
            String stockCode, String dis_code, String list_price, String prod_class, String valn
    ) throws Exception {
        pricingPages = new PricingPages();
        Object[] vals = {stockCode, dis_code, list_price, prod_class, valn};
        Assert.assertTrue(pricingPages.addProduct_EmptyStockCode(vals));
    }
}
