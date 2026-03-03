package com.exergy.pages;

import com.microsoft.playwright.Page;
import org.athena.BasePage;

public class CapturePolicyPage extends BasePage {

    private Page page;

    public CapturePolicyPage(Page page) {
        super(page);
        this.page = page;
    }
}
