package com.tests;

import com.pages.PricingPages;
import com.resources.OpenBrowser;
import org.testng.annotations.Test;

public class PricingTests extends OpenBrowser {
    public PricingPages pricingPages;

    @Test(priority = 1)
    public void addProductTest() throws Exception {
        pricingPages = new PricingPages();
        pricingPages.addProduct("87637846782", "BACO44", 342.21, "BA01");
    }
}
