package com.tests;

import com.pages.LoginPages;
import com.pages.PricingPages;
import com.resources.OpenBrowser;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PricingTests extends OpenBrowser {
    public PricingPages pricingPages;
    public LoginPages loginPages;

    @Parameters({"stockCode", "discountCode", "listPrice", "productClass", "validation"})
    @Test(priority = 1)
    public void addProductTest_EmptyStockCode(
            String stockCode, String dis_code, double list_price, String prod_class, String valn
    ) throws Exception {
        pricingPages = new PricingPages();
        Object[] vals = {stockCode, dis_code, list_price, prod_class, valn};
        boolean testResult = pricingPages.addProduct_EmptyStockCode(vals);
        Assert.assertTrue(testResult);
        if (testResult) {
            pricingPages.loginPages.logout();
        }
    }
}
