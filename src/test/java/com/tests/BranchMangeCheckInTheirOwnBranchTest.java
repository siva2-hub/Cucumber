package com.tests;

import com.pages.SalesDashBoardPages;
import com.resources.OpenBrowser;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class BranchMangeCheckInTheirOwnBranchTest extends OpenBrowser {
    public SalesDashBoardPages sales = new SalesDashBoardPages();;
    @Test(enabled = false)
    public void checkSalesManagerInOwnBranchTest() throws Exception {

        boolean testResult = sales.checkSalesManagerInOwnBranch("Dallas","Test Default", true);
        Assert.assertTrue(testResult);
    }
    @Test
    public void checkUserGoals() throws Exception {
        sales.checkGoalsForDifferentSales();
    }
}
