package com.exergy.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.exergy.constants.CapturePolicyConstants.*;
import static com.exergy.utils.TestDataGenerator.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;

public class CapturePolicyPage extends ExergyBasePage {

    private Page page;

    private Locator idInput;
    private Locator searchIcon;
    private Locator titleDropdown;
    private Locator firstNameInput;
    private Locator surnameInput;
    private Locator genderDropdown;
    private Locator dobInput;
    private Locator productDropdown;
    private Locator addButton;
    private Locator policyNumberInput;

    public CapturePolicyPage(Page page) {
        super(page);
        this.page = page;
        this.idInput = page.locator("#DefaultIDNumber");
        this.searchIcon = page.locator("#doSearch");
        this.titleDropdown = page.locator("#TitleID");
        this.firstNameInput = page.locator("#FirstName");
        this.surnameInput = page.locator("#Surname");
        this.genderDropdown = page.locator("#GenderID");
        this.dobInput = page.locator("#DateOfBirth");
        this.productDropdown = page.locator("#cboSelectProduct");
        this.addButton = page.locator("#btnAdd");
        this.policyNumberInput = page.locator("#txtPolicyRefNo");
    }

    @Step("Enter identity number")
    private CapturePolicyPage enterIdentityType(String valueToEnter) {
        idInput.clear();
        idInput.fill(valueToEnter);

        return this;
    }

    @Step("Click on search icon")
    private CapturePolicyPage clickSearchIcon() {
        searchIcon.click();

        return this;
    }

    @Step("Select title value")
    private CapturePolicyPage selectTitleValue(String valueToSelect) {
        selectDropdownValue(titleDropdown, valueToSelect);

        return this;
    }

    @Step("Enter first name")
    private CapturePolicyPage enterFirstName(String valueToEnter) {
        firstNameInput.clear();
        firstNameInput.fill(valueToEnter);

        return this;
    }

    @Step("Enter surname")
    private CapturePolicyPage enterSurname(String valueToEnter) {
        surnameInput.clear();
        surnameInput.fill(valueToEnter);

        return this;
    }

    @Step("Select gender value")
    private CapturePolicyPage selectGender(String valueToSelect) {
        selectDropdownValue(genderDropdown, valueToSelect);

        return this;
    }

    @Step("Enter date of birth")
    private CapturePolicyPage enterDateOfBirth(String valueToEnter) {
        dobInput.fill(valueToEnter);

        return this;
    }

    @Step("Select product type value")
    private CapturePolicyPage selectProductType(String valueToSelect) {
        selectDropdownValue(productDropdown, valueToSelect);

        return this;
    }

    @Step("Click on add button")
    private CapturePolicyPage clickOnAddButton() {
        addButton.click();

        return this;
    }

    @Step("Create random client")
    public CapturePolicyPage createRandomClient() {
        enterIdentityType(generateRandomNumber(12))
                .clickSearchIcon()
                .selectTitleValue(TITLE)
                .enterFirstName(generateRandomValue(7))
                .enterSurname(generateRandomValue(7))
                .selectGender(MALE)
                .enterDateOfBirth(dateYearsBackIso(40))
                .selectProductType(BOTSHELO_WHOLE_LIFE)
                .clickOnAddButton();
        attachScreenshot(page, "Creating random client");

        return this;
    }

    @Step("Check that client is created and policy number is generated")
    public CapturePolicyPage checkPolicyNumberGenerated() {
        assertThat(policyNumberInput).hasValue(Pattern.compile("\\S+"));
        attachScreenshot(page, "Client is created and policy number is generated");

        return this;
    }
}
