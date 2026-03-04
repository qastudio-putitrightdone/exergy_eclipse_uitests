package com.base;

import com.exergy.pages.LoginPage;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class ExergyAuthenticatedBase extends BaseTest {

    @BeforeMethod
    protected void loginToExergy(ITestResult iTestResult) {
        ExergyUsers exergyUsers = (ExergyUsers) iTestResult.getParameters()[0];

        LoginPage loginPage = new LoginPage(page);
        loginPage.loginToExergyApp(exergyUsers.getUserName(), exergyUsers.getPassword());
    }
}
