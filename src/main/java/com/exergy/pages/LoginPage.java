package com.exergy.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage extends ExergyBasePage {

    private Page page;

    private Locator usernameInput;
    private Locator passwordInput;
    private Locator loginButton;

    public LoginPage(Page page) {
        super(page);
        this.page = page;
        this.usernameInput = page.locator("#inputTxtUsername");
        this.passwordInput = page.locator("#inputTxtPassword");
        this.loginButton = page.locator("#loginSubmitBtn");
    }

    @Step("Enter username")
    private LoginPage enterUsername(String username) {
        usernameInput.clear();
        usernameInput.fill(username);

        return this;
    }

    @Step("Enter password")
    private LoginPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.fill(password);

        return this;
    }

    @Step("Click on login button")
    private LoginPage clickOnLoginButton() {
        loginButton.click();

        return this;
    }

    @Step("Login to Exergy App")
    public DashboardPage loginToExergyApp(String username, String password) {
        enterUsername(username)
                .enterPassword(password)
                .clickOnLoginButton();

        return new DashboardPage(page);
    }
}
