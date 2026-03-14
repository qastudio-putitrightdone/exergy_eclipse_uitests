package com.base;

import com.exergy.pages.LoginPage;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class ExergyAuthenticatedBase extends BaseTest {

    @BeforeMethod
    protected void loginToExergy(ITestResult iTestResult) {
        ExergySessionManager exergySessionManager = new ExergySessionManager();

        if (!exergySessionManager.checkStorageState()) {
            ExergyUsers exergyUsers = (ExergyUsers) iTestResult
                    .getParameters()[0];

            LoginPage loginPage = new LoginPage(playwrightPage.get());
            loginPage
                    .loginToExergyApp(exergyUsers.getUserName(), exergyUsers.getPassword())
                    .verifyDashboardNavigation();
            exergySessionManager.captureActiveSession(browserContextThreadLocal.get());
        }
    }
}
