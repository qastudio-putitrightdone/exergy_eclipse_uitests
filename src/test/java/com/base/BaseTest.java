package com.base;

import com.exergy.pages.CapturePolicyPage;
import com.exergy.pages.DashboardPage;
import com.exergy.utils.PageType;
import com.microsoft.playwright.Page;
import org.athena.BasePage;
import org.athena.LaunchBrowser;
import org.athena.ReadConfigData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Properties;

import static com.exergy.utils.AppUrlConstants.*;

public class BaseTest {

    LaunchBrowser launchBrowser = new LaunchBrowser();

    protected Page page;

    private static Properties fetchBaseConfig() {
        String baseConfig = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        ReadConfigData readConfigData = new ReadConfigData();
        return readConfigData.fetchConfigData(baseConfig);
    }

    @BeforeMethod
    public void initiateAndLaunchBrowser() {
        String appUrl = fetchBaseConfig().getProperty("url");
        String browserToLaunch = fetchBaseConfig().getProperty("Browser");
        List<Object> farmeworkObjects = launchBrowser.initiateBrowserAndApplication(browserToLaunch, appUrl);
        page = (Page) farmeworkObjects.get(2);
    }

    @AfterMethod
    public void cleanUp() {
        launchBrowser.CleanUpAndGarbageCollect();
    }

    protected <T extends BasePage> T navigateTo(PageType pageType) {
        String baseUrl = fetchBaseConfig().getProperty("baseUrl");

        switch (pageType) {
            case DASHBOARD:
                page.navigate(baseUrl + DASHBOARD_PATH);
                return (T) new DashboardPage(page);

            case CAPTURE_POLICY:
                page.navigate(baseUrl + CAPTURE_POLICY_PATH);
                return (T) new CapturePolicyPage(page);

            default:
                throw new IllegalArgumentException("Unknown page: " + pageType);
        }
    }
}
