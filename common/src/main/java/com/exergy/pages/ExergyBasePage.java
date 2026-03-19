package com.exergy.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.athena.BasePage;

public class ExergyBasePage extends BasePage {

    public ExergyBasePage(Page page) {
        super(page);
    }

    public ExergyBasePage selectDropdownValue(Locator locator, String valueToSelect) {
        locator.selectOption(valueToSelect);

        return this;
    }
}
