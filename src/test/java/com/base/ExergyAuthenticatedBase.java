package com.base;

import com.exergy.pages.LoginPage;
import com.microsoft.playwright.BrowserContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class ExergyAuthenticatedBase extends BaseTest {

    @BeforeMethod
    protected void loginToExergy(ITestResult iTestResult) {
        ExergySessionManager exergySessionManager = new ExergySessionManager();

        ExergyUsers exergyUsers = (ExergyUsers) iTestResult
                .getParameters()[0];

        if (!exergySessionManager.checkStorageState()) {
            LoginPage loginPage = new LoginPage(playwrightPage.get());
            loginPage
                    .loginToExergyApp(exergyUsers.getUserName(), exergyUsers.getPassword())
                    .verifyDashboardNavigation();
            exergySessionManager.captureActiveSession(playwrightPage.get());
        } else {
            exergySessionManager.setSessionForUser(browserThread.get());
        }
    }
}
