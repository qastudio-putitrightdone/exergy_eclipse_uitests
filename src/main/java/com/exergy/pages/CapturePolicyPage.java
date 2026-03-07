package com.exergy.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.exergy.constants.CapturePolicyConstants.*;
import static com.exergy.constants.PolicyMessageConstants.POLICY_CREATED_MESSAGE;
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
    private Locator isFixedCheckBox;
    private Locator editBenefitIcon;
    private Locator coverInput;
    private Locator closeButton;
    private Locator paymentTypeDropdown;
    private Locator addBeneficiaryIcon;
    private Locator selectClientDropdown;
    private Locator relationshipDropdown;
    private Locator beneficieryTypeDropdown;
    private Locator beneficieryPercntInput;
    private Locator okBeneficieryButton;
    private Locator editCommissionIcon;
    private Locator addCommisionButton;
    private Locator searchLevelCodeInput;
    private Locator searchLevelCodeIcon;
    private Locator distributionContractDropdown;
    private Locator okComissionButton;
    private Locator cancelCommsionButton;
    private Locator validateButton;
    private Locator toastMessage;
    private Locator proposerLink;
    private Locator medicalReqCheckbox1;
    private Locator medicalReqCheckbox2;
    private Locator receiveRequirementsButton;
    private Locator addPolicyPopup;
    private Locator clientRadioButton;

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
        this.isFixedCheckBox = page.locator("#chkIsCommencedateFixed");
        this.editBenefitIcon = page.locator("#EditBenefit");
        this.coverInput = page.locator("#editCover");
        this.closeButton = page.locator("#btnCloseModal");
        this.paymentTypeDropdown = page.locator("#PaymentTypeID");
        this.addBeneficiaryIcon = page.locator("#iconShowAddBeneficiary");
        this.selectClientDropdown = page.locator("#cboSelectClient");
        this.relationshipDropdown = page.locator("#RelationshipID");
        this.beneficieryTypeDropdown = page.locator("#BeneficiaryTypeID");
        this.beneficieryPercntInput = page.locator("#BeneficiaryPercentage");
        this.okBeneficieryButton = page.locator("#btnAddBeneficiary");
        this.editCommissionIcon = page.locator("#EditCommission");
        this.addCommisionButton = page.locator("#btnAddComms");
        this.searchLevelCodeInput = page.locator("#txtSearchCriteria");
        this.searchLevelCodeIcon = page.locator("#dosearch");
        this.distributionContractDropdown = page.locator("#DistributionTypeID");
        this.okComissionButton = page.locator("#bntOK");
        this.cancelCommsionButton = page.locator("#btnCancelModal");
        this.validateButton = page.locator("#btnValidate");
        this.toastMessage = page.locator(".blazored-toast-message");
        this.proposerLink = page.locator("#ProposerSalutation");
        this.medicalReqCheckbox1 = page.locator("#chkRequiremenrReceived-1");
        this.medicalReqCheckbox2 = page.locator("#chkRequiremenrReceived-0");
        this.receiveRequirementsButton = page.locator("#btnReceiveRequirements");
        this.addPolicyPopup = page.locator("#modalAddDiv");
        this.clientRadioButton = page.locator("#radClient");
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

    @Step("Click on fixed check box")
    public CapturePolicyPage clickIsFixedCheckbox() {
        isFixedCheckBox.check();
        attachScreenshot(page, "Clicking is fixed checkbox");

        return this;
    }

    @Step("Click on edit benefit icon")
    private CapturePolicyPage clickOnEditBenefitIcon() {
        editBenefitIcon.click();

        return this;
    }

    @Step("Enter cover")
    private CapturePolicyPage enterCover(String valueToEnter) {
        coverInput.clear();
        coverInput.fill(valueToEnter);

        return this;
    }

    @Step("Click on close button")
    private CapturePolicyPage clickOnCloseButton() {
        closeButton.click();

        return this;
    }

    @Step("Adding benefit details")
    public CapturePolicyPage addBenefitDetails(String coverAmount) {
        clickOnEditBenefitIcon()
                .enterCover(coverAmount)
                .clickOnCloseButton();
        attachScreenshot(page, "Added benefit Information.");

        return this;
    }

    @Step("Selecting payment type")
    private CapturePolicyPage selectPaymentType(String valueToSelect) {
        selectDropdownValue(paymentTypeDropdown, valueToSelect);

        return this;
    }

    @Step("Adding payment details")
    public CapturePolicyPage addPaymentDetails(String paymentType) {
        selectPaymentType(paymentType);
        attachScreenshot(page, "Added Payment details");

        return this;
    }

    @Step("Click on add beneficiary button")
    private CapturePolicyPage clickOnAddBeneficieryIcon() {
        addBeneficiaryIcon.click();

        return this;
    }

    @Step("Select client drop down value")
    private CapturePolicyPage selectClientValue(String valueToSelect) {
        selectDropdownValue(selectClientDropdown, valueToSelect);

        return this;
    }

    @Step("Select relationship drop down value")
    private CapturePolicyPage selectRelationshipValue(String valueToSelect) {
        selectDropdownValue(relationshipDropdown, valueToSelect);

        return this;
    }

    @Step("Select beneficiary type drop down value")
    private CapturePolicyPage selectBeneficieryType(String valueToSelect) {
        selectDropdownValue(beneficieryTypeDropdown, valueToSelect);

        return this;
    }

    @Step("Enter beneficiary percentage value")
    private CapturePolicyPage enterbeneceryPercnt(String valueToEnter) {
        beneficieryPercntInput.clear();
        beneficieryPercntInput.fill(valueToEnter);

        return this;
    }

    @Step("Click on OK button")
    private void clickOkBeneficieryButton() {
        okBeneficieryButton.click();
    }

    @Step("Adding beneficiary details")
    public CapturePolicyPage addBeneficiaryDetails() {
        clickOnAddBeneficieryIcon()
                .selectClientValue(SEARCH_FOR_CLIENT)
                .enterIdentityType(generateRandomNumber(12))
                .clickSearchIcon()
                .selectTitleValue(TITLE)
                .enterFirstName(generateRandomValue(7))
                .enterSurname(generateRandomValue(7))
                .selectGender(MALE)
                .enterDateOfBirth(dateYearsBackIso(40))
                .selectRelationshipValue(BROTHER)
                .selectBeneficieryType(BENEFICIERY_TYPE_DEATH_TRANSFER)
                .enterbeneceryPercnt(BENEFICIERY_PERCENT)
                .clickOkBeneficieryButton();
        attachScreenshot(page, "Adding beneficiry information");

        return this;
    }

    @Step("Click on edit comission details")
    private CapturePolicyPage clickEditComissionIcon() {
        editCommissionIcon.click();

        return this;
    }

    @Step("Click on add commission button")
    private CapturePolicyPage clickAddComissionButton() {
        addCommisionButton.click();

        return this;
    }

    @Step("Searching level code")
    private CapturePolicyPage searchLevelCode(String valueToSearch) {
        searchLevelCodeInput.dblclick();
        searchLevelCodeInput.clear();
        searchLevelCodeInput.fill(valueToSearch);
        searchLevelCodeIcon.click();

        return this;
    }

    @Step("Select Distribution contract drop down value")
    private CapturePolicyPage selectDistributionContractValue(String valueToSelect) {
        selectDropdownValue(distributionContractDropdown, valueToSelect);

        return this;
    }

    @Step("Click on OK commission button")
    private CapturePolicyPage clickOkComissionButton() {
        okComissionButton.click();

        return this;
    }

    @Step("Close commission modal pop up")
    private CapturePolicyPage closeCommissionButton() {
        page.waitForCondition(()-> cancelCommsionButton.all().size() == 1);
        cancelCommsionButton.click();

        return this;
    }

    @Step("Adding commission details")
    public CapturePolicyPage addComission() {
        clickEditComissionIcon()
                .clickAddComissionButton()
                .searchLevelCode(LEVEL_CODE)
                .selectDistributionContractValue(ADVANCABLE_COMMISSION)
                .clickOkComissionButton()
                .closeCommissionButton();
        attachScreenshot(page, "Adding commission information");

        return this;
    }

    @Step("Click on received requirement button")
    private CapturePolicyPage clickOnReceiveReqButton() {
        receiveRequirementsButton.click();
        page.waitForCondition(() -> !receiveRequirementsButton.isVisible());

        return this;
    }

    @Step("Click on medical requirement check boxes")
    public CapturePolicyPage checkMedicalReqCheckboxes() {
        medicalReqCheckbox1.check();
        medicalReqCheckbox2.check();
        clickOnReceiveReqButton();
        attachScreenshot(page, "Selecting medical Requirements checkboxes");

        return this;
    }

    @Step("Click on validate button to check error toast message")
    public CapturePolicyPage clickOnValidateButtonCheckError() {
        validateButton.click();
        page.waitForCondition(() -> toastMessage.isVisible());
        page.waitForCondition(() -> !toastMessage.isVisible());
        attachScreenshot(page, "Clicking Validate button");

        return this;
    }

    @Step("Click on validate button")
    public CapturePolicyPage clickOnValidateButton() {
        validateButton.click();
        attachScreenshot(page, "Clicking validate button to create policy");

        return this;
    }

    @Step("Check policy creation toast message")
    public CapturePolicyPage checkPolicyCreationMessage() {
        page.waitForCondition(() -> toastMessage.isVisible());
        assertThat(toastMessage).hasText(POLICY_CREATED_MESSAGE);
        attachScreenshot(page, "Checking policy creation toast  message");

        return this;
    }

    @Step("Click on proposer name link")
    public EditClientPage clickOnProposerLink() {
        Page page1 = page.waitForPopup(() -> proposerLink.click());

        return new EditClientPage(page1);
    }

    @Step("Check add policy pop up")
    public CapturePolicyPage checkAddPolicyPopup() {
        assertThat(addPolicyPopup).isVisible();
        attachScreenshot(page, "Check Add policy pop up");

        return this;
    }

    @Step("Check client radio button selected")
    public CapturePolicyPage checkClientRadioSelected() {
        assertThat(clientRadioButton).isChecked();
        attachScreenshot(page, "Check Client radio option is selected");

        return this;
    }
}

