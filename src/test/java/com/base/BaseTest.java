package com.base;

import com.exergy.pages.CapturePolicyPage;
import com.exergy.pages.DashboardPage;
import com.exergy.pages.PolicySearchPage;
import com.exergy.utils.PageType;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.athena.BasePage;
import org.athena.LaunchBrowser;
import org.athena.ReadConfigData;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.exergy.utils.AppUrlConstants.*;
import static com.exergy.utils.ScreenshotUtils.captureScreenshot;

public class BaseTest {

    LaunchBrowser launchBrowser = new LaunchBrowser();
    ExergySessionManager exergySessionManager = new ExergySessionManager();

    protected ThreadLocal<Page> playwrightPage = new ThreadLocal<>();
    protected ThreadLocal<Browser> browserThread = new ThreadLocal<>();

    private static Properties fetchBaseConfig() {
        String baseConfig = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        ReadConfigData readConfigData = new ReadConfigData();
        return readConfigData.fetchConfigData(baseConfig);
    }

    @BeforeMethod
    public void initiateAndLaunchBrowser() {
        List<Object> frameworkObjects = new ArrayList<>();
        String appUrl = fetchBaseConfig().getProperty("url");
        String browserToLaunch = fetchBaseConfig().getProperty("Browser");
        if (!exergySessionManager.checkStorageState()) {
            frameworkObjects = launchBrowser.initiateBrowserAndApplication(browserToLaunch, appUrl);
        } else {
            frameworkObjects = launchBrowser.initiateBrowserAndApplication(browserToLaunch,
                    appUrl, Paths.get("ExergySession.json"));
        }
        playwrightPage.set((Page) frameworkObjects.get(2));
        browserThread.set((Browser) frameworkObjects.get(3));
        playwrightPage.get().setDefaultTimeout(60000);
        PlaywrightAssertions.setDefaultAssertionTimeout(60000);
        playwrightPage.get().setDefaultNavigationTimeout(60000);
    }

    @AfterMethod
    public void cleanUp(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            byte[] screenshot = captureScreenshot(playwrightPage.get());
            Allure.addAttachment("Failed test" + System.currentTimeMillis(), "image/png",
                    new ByteArrayInputStream(screenshot), "png");
            if (iTestResult.getThrowable().getMessage().contains("timeout")) {
                Allure.step("Test case failed: " + iTestResult.getName(), Status.BROKEN);
                Allure.label("Failure Reason", "Timeout Error / Locator not available/actionable/missing/hidden");
            } else {
                Allure.step("Test case failed: " + iTestResult.getName(), Status.FAILED);
                Allure.label("Failure Reason", "Assertion Failure , Product Defect");
            }
        } else if (iTestResult.getStatus() == ITestResult.SKIP) {
            Allure.step("Test case skipped: " + iTestResult.getTestName(), Status.SKIPPED);
        }
        playwrightPage.get().close();
        launchBrowser.CleanUpAndGarbageCollect();
    }

    protected <T extends BasePage> T navigateTo(PageType pageType) {
        String baseUrl = fetchBaseConfig().getProperty("baseUrl");

        switch (pageType) {
            case DASHBOARD:
                playwrightPage.get().navigate(baseUrl + DASHBOARD_PATH);
                return (T) new DashboardPage(playwrightPage.get());

            case CAPTURE_POLICY:
                playwrightPage.get().navigate(baseUrl + CAPTURE_POLICY_PATH);
                return (T) new CapturePolicyPage(playwrightPage.get());

            case POLICY_SEARCH:
                playwrightPage.get().navigate(baseUrl + POLICY_SEARCH_PATH);
                return (T) new PolicySearchPage(playwrightPage.get());

            default:
                throw new IllegalArgumentException("Unknown page: " + pageType);
        }
    }
}
