package com.exergy.utils;

import com.microsoft.playwright.Page;

public class ScreenshotUtils {

    public static byte[] captureScreenshot(Page playwrightPage) {
        return playwrightPage.screenshot();
    }
}
