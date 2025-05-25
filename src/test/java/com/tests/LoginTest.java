package com.tests;

import com.pages.LoginPages;
import com.resources.OpenBrowser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends OpenBrowser {
    public LoginPages loginPages;
    @Test(priority = 1)
    public void loginTest() throws Exception {
        loginPages= new LoginPages();
        boolean testStatus = loginPages.verifyLogin();
        Assert.assertTrue(testStatus);
    }
}
