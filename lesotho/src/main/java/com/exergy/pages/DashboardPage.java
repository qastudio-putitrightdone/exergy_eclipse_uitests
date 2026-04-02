package com.exergy.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import java.util.regex.Pattern;

import static com.exergy.constants.PolicyMessageConstants.POLICY_REF_NOT_FOUND;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DashboardPage extends ExergyBasePage {

    private Page page;

    private Locator openPolicyInput;
    private Locator openButton;

    public DashboardPage(Page page) {
        super(page);
        this.page = page;
        this.openPolicyInput = page.locator("#txtSearchPolicyRefNo");
        this.openButton = page.locator("#btnOpenPolicyView");
    }

    @Step("Verify Dashboard page navigation")
    public DashboardPage verifyDashboardNavigation() {
        page.waitForURL(Pattern.compile(".*/home.*", Pattern.CASE_INSENSITIVE));
        attachScreenshot(page, "Navigated to dashboard screen");

        return this;
    }

    @Step("Enter value in open a policy search field")
    public DashboardPage enterPolicyNumberInOpenPolicy(String valueToEnter) {
//        openPolicyInput.click();
        openPolicyInput.clear();
        openPolicyInput.fill(valueToEnter);
        attachScreenshot(page, "Enter value in Open a policy text field");

        return this;
    }

    @Step("Click on open button")
    public DashboardPage clickOnOpenButton() {
        openButton.click(new Locator.ClickOptions().setDelay(3000));

        return this;
    }

    @Step("Check that Policy not found error pop up is displayed")
    public void checkPolicyRefNotFoundPopup() {
        assertThat(page.getByText(POLICY_REF_NOT_FOUND, new Page.GetByTextOptions().setExact(true))).isVisible();
        attachScreenshot(page, "Verify that Policy reference not found error pop up is displayed");
    }
}
