package com.exergy.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class DashboardPage extends ExergyBasePage {

    private Page page;

    public DashboardPage(Page page) {
        super(page);
        this.page = page;
    }

    @Step("Verify Dashboard page navigation")
    public DashboardPage verifyDashboardNavigation() {
        page.waitForURL("**/home/**");
        attachScreenshot(page, "Navigated to dashboard screen");

        return this;
    }
}
