package com.exergy.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PolicySearchPage extends ExergyBasePage {

    private Page page;

    private Locator productDropdown;
    private Locator searchButton;
    private Locator tableData;
    private Locator noSearchMessage;
    private Locator tabledRows;

    public PolicySearchPage(Page page) {
        super(page);
        this.page = page;
        this.productDropdown = page.locator("#lstSelectContractType");
        this.searchButton = page.locator("#btnAdvanceSearch");
        this.tableData = page.locator("#myTable_AdvanceSearchResults");
        this.noSearchMessage = page.getByLabel("No results returned", new Page.GetByLabelOptions().setExact(true));
        this.tabledRows = tableData.locator("tr");
    }

    @Step("Validate Policy search page navigation")
    public PolicySearchPage validatePolicySearchPagNavigation() {
        page.waitForURL("**/AdvancedSearch/Item");
        attachScreenshot(page, "Navigated to Policy search page");

        return this;
    }

    @Step("Selecting value in Product drop down")
    public PolicySearchPage selectProductValue(String valueToSelect) {
        selectDropdownValue(productDropdown, valueToSelect);

        return this;
    }

    @Step("Clicking on search button")
    public PolicySearchPage clickOnSearchButton() {
        searchButton.click();

        return this;
    }

    @Step("Check that Searched values is available in table")
    public PolicySearchPage checkSearchedValueAvailableInTable(String searchedValue) {
        assertThat(tableData.filter(new Locator.FilterOptions().setHasText(searchedValue))).isVisible();
        attachScreenshot(page, "Searched results values");

        return this;
    }

    @Step("Check that No result returned displayed")
    public PolicySearchPage checkNoResultReturnedDisplayed() {
        assertThat(noSearchMessage).isVisible();
        attachScreenshot(page, "No result returned displayed");

        return this;
    }

    @Step("Check that search results are available")
    public PolicySearchPage checkSearchResultsAvailable() {
        assertThat(tabledRows.first()).isVisible();
        attachScreenshot(page, "Search results available");

        return this;
    }
}
