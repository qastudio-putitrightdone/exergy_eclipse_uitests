package com.exergy.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.athena.BasePage;

public class DashboardPage extends BasePage {

    private Page page;

    public DashboardPage(Page page) {
        super(page);
        this.page = page;
    }

    @Step("Verify Dashboard page navigation")
    public DashboardPage verifyDashboardNavigation() {
        page.waitForURL("**/Home");
        attachScreenshot(page, "Navigated to dashboard screen");

        return this;
    }
}
