package com.exergy.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class EditClientPage {

    private Page page;

    private Locator additionalInfoLink;
    private Locator maritalStatusDropdown;
    private Locator qualificationDropdown;
    private Locator placeOfBirthInput;
    private Locator cntrOfResidencyDropdown;
    private Locator incomeGroupDropdown;
    private Locator contryOfBirthDropdown;

    public EditClientPage(Page page) {
        this.page = page;
        this.additionalInfoLink = page.locator("#showmore");
        this.maritalStatusDropdown = page.locator("#MaritalStatusID");
        this.qualificationDropdown = page.locator("#HighestQualificationTypeID");
        this.placeOfBirthInput = page.locator("#PlaceOfBirth");
        this.cntrOfResidencyDropdown = page.locator("#CountryOfResidencyID");
        this.incomeGroupDropdown = page.locator("#IncomeGroupID");
        this.contryOfBirthDropdown = page.locator("#CountryOfBirthID");
    }
}
