package com.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExergySessionManager {

    public void captureActiveSession(BrowserContext browserContext) {
        browserContext
                .storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("ExergySession.json")));
    }

    public boolean checkStorageState() {
        Path storageSessionPath = Paths.get("ExergySession.json");
        if (Files.exists(storageSessionPath)) {
            return true;
        } else {
            return false;
        }
    }

    public Path getStorageState() {
        return Paths.get("ExergySession.json");
    }

    public Page setSessionForUser(Browser browser) {
        return browser.newContext(new Browser.NewContextOptions()
                .setStorageStatePath(Paths.get("ExergySession.json"))).newPage();
    }
}
