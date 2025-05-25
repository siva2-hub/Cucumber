package com.tests;

import com.pages.SalesDashBoardPages;
import com.resources.OpenBrowser;
import org.testng.annotations.Test;

public class BranchMangeCheckInTheirOwnBranchTest extends OpenBrowser {

    @Test
    public void salesManagerInOwnBranchTest() throws Exception {
        SalesDashBoardPages sales = new SalesDashBoardPages();
        sales.checkSalesManagerInOwnBranch("Dallas","Test Default");
    }
}
