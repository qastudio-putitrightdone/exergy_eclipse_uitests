package com.exergy.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.ByteArrayInputStream;

import static com.exergy.constants.CapturePolicyConstants.*;
import static com.exergy.utils.TestDataGenerator.*;

public class EditClientPage {

    private Page page;

    private Locator additionalInfoLink;
    private Locator maritalStatusDropdown;
    private Locator qualificationDropdown;
    private Locator placeOfBirthInput;
    private Locator cntrOfResidencyDropdown;
    private Locator incomeGroupDropdown;
    private Locator contryOfBirthDropdown;
    private Locator smokingDropdown;
    private Locator contactDetailsSection;
    private Locator mobileNumberInput;
    private Locator emailIdInput;
    private Locator addressDetailsSection;
    private Locator postalAddressInput;
    private Locator homeAddressCountryDropdown;
    private Locator postalAddressPinInput;
    private Locator resAddrsInput;
    private Locator resCountryDropdown;
    private Locator resAddrsPinInput;

    public EditClientPage(Page page) {
        this.page = page;
        this.additionalInfoLink = page.locator("#showmore");
        this.maritalStatusDropdown = page.locator("#MaritalStatusID");
        this.qualificationDropdown = page.locator("#HighestQualificationTypeID");
        this.placeOfBirthInput = page.locator("#PlaceOfBirth");
        this.cntrOfResidencyDropdown = page.locator("#CountryOfResidencyID");
        this.incomeGroupDropdown = page.locator("#IncomeGroupID");
        this.contryOfBirthDropdown = page.locator("#CountryOfBirthID");
        this.smokingDropdown = page.locator("#SmokingID");
        this.contactDetailsSection = page.locator("#ContactDetailsSection");
        this.mobileNumberInput = page.locator("#txtClientDefaultMobileNumber");
        this.emailIdInput = page.locator("#txtClientDefaultEmailAddress");
        this.addressDetailsSection = page.locator("#ClientAddressInfoSection");
        this.postalAddressInput = page.locator("#DefaultHomeAddress");
        this.homeAddressCountryDropdown = page.locator("#DefaultHomeAddressCountryID");
        this.postalAddressPinInput = page.locator("#DefaultHomeAddressZipCode");
        this.resAddrsInput = page.locator("#DefaultStreetAddressValue");
        this.resCountryDropdown = page.locator("#DefaultStreetAddressCountryID");
        this.resAddrsPinInput = page.locator("#DefaultStreetAddressZipCode");
    }

    @Step("Click on additional info")
    private EditClientPage clickOnAdditionalInfoLink() {
        additionalInfoLink.click();

        return this;
    }

    @Step("Selecting marital status drop down value")
    private EditClientPage selectMaritalStatusValue(String valueToSelect) {
        maritalStatusDropdown.selectOption(valueToSelect);

        return this;
    }

    @Step("Select highest qualification drop down value")
    private EditClientPage selectQualificationValue(String valueToSelect) {
        qualificationDropdown.selectOption(valueToSelect);

        return this;
    }

    @Step("Enter place of birth")
    private EditClientPage enterPlaceOfBirth(String valueToEnter) {
        placeOfBirthInput.clear();
        placeOfBirthInput.fill(valueToEnter);

        return this;
    }

    @Step("Select country of residency drop down value")
    private EditClientPage selectCountryOfResidencyValue(String valueToSelect) {
        cntrOfResidencyDropdown.selectOption(valueToSelect);

        return this;
    }

    @Step("Select income group drop down value")
    private EditClientPage selectIncomeGroupValue(String valueToSelect) {
        incomeGroupDropdown.selectOption(valueToSelect);

        return this;
    }

    @Step("Select country of birth drop down value")
    private void selectCountryOfBirthValue(String valueToSelect) {
        contryOfBirthDropdown.selectOption(valueToSelect);
    }

    @Step("Select smoking drop down value")
    private EditClientPage selectSmokingValue(String valueToSelect) {
        smokingDropdown.selectOption(valueToSelect);

        return this;
    }

    @Step("Add basic client details values")
    private EditClientPage addBasicClientDetails() {
        clickOnAdditionalInfoLink()
                .selectMaritalStatusValue(MARRIED)
                .selectQualificationValue(BGCSE)
                .enterPlaceOfBirth(BOTSWANA)
                .selectCountryOfResidencyValue(BOTSWANA)
                .selectIncomeGroupValue(INCOME_GROUP)
                .selectSmokingValue(NON_SMOKER)
                .selectCountryOfBirthValue(BOTSWANA);
        captureScreenshot(page, "Adding basic details values");

        return this;
    }

    @Step("Clicking on contact details section")
    private EditClientPage clickOnContactDetailsSection() {
        contactDetailsSection.click();

        return this;
    }

    @Step("Enter mobile number")
    private EditClientPage enterMobileNumber(String valueToEnter) {
        mobileNumberInput.clear();
        mobileNumberInput.fill(valueToEnter);

        return this;
    }

    @Step("Enter email address")
    private EditClientPage enterEmailId(String valueToEnter) {
        emailIdInput.clear();
        emailIdInput.fill(valueToEnter);

        return this;
    }

    @Step("Add contact details values")
    private EditClientPage enterContactDetails() {
        clickOnContactDetailsSection()
                .enterMobileNumber(IndiaMobileNumberGenerator())
                .enterEmailId(generateRandomEmail());
        captureScreenshot(page, "Adding contact details values");

        return this;
    }

    @Step("Clicking on address details section")
    private EditClientPage clickOnAddressDetailsSection() {
        addressDetailsSection.click();

        return this;
    }

    @Step("Enter postal address")
    private EditClientPage enterPostalAddress() {
        postalAddressInput.clear();
        postalAddressInput.fill(generateRandomValue(20));

        return this;
    }

    @Step("Select postal country drop down value")
    private EditClientPage selectPostalAdrCountry(String valueToSelect) {
        homeAddressCountryDropdown.selectOption(valueToSelect);

        return this;
    }

    @Step("Enter postal pin code")
    private EditClientPage enterPostalPincode(String valueToEnter) {
        postalAddressPinInput.clear();
        postalAddressPinInput.fill(valueToEnter);

        return this;
    }

    @Step("Enter residency address")
    private EditClientPage enterResAddress() {
        resAddrsInput.clear();
        resAddrsInput.fill(generateRandomValue(20));

        return this;
    }

    @Step("Select residency country drop down")
    private EditClientPage selectResAdrCountry(String valueToSelect) {
        resCountryDropdown.selectOption(valueToSelect);

        return this;
    }

    @Step("Enter residency pin code")
    private EditClientPage enterResPincode(String valueToEnter) {
        resAddrsPinInput.clear();
        resAddrsPinInput.fill(valueToEnter);

        return this;
    }

    @Step("Adding address details values")
    private EditClientPage addAddressDetails() {
        clickOnAddressDetailsSection()
                .enterPostalAddress()
                .selectPostalAdrCountry(BOTSWANA)
                .enterPostalPincode(generateRandomNumber(4))
                .enterResAddress()
                .selectResAdrCountry(BOTSWANA)
                .enterResPincode(generateRandomNumber(4));
        captureScreenshot(page, "Adding address details values");

        return this;
    }

    @Step("Selecting client additional details")
    public EditClientPage selectClientAdditionalDetails() {
        addBasicClientDetails()
                .enterContactDetails()
                .addAddressDetails();
        captureScreenshot(page, "Selecting client additional details");

        return this;
    }

    private void captureScreenshot(Page page, String screenshotName) {
        byte[] screenshot = page.screenshot();
        Allure.addAttachment(screenshotName, "image/png", new ByteArrayInputStream(screenshot), "png");
    }
}
