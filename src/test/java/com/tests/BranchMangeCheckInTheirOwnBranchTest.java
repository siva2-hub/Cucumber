package com.tests;

import com.pages.SalesDashBoardPages;
import com.resources.OpenBrowser;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class BranchMangeCheckInTheirOwnBranchTest extends OpenBrowser {

    @Test
    public void checkSalesManagerInOwnBranchTest() throws Exception {
        SalesDashBoardPages sales = new SalesDashBoardPages();
        boolean testResult = sales.checkSalesManagerInOwnBranch("Dallas","Test Default", true);
        Assert.assertTrue(testResult);
    }
}
