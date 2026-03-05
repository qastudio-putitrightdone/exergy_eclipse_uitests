package com.capture_policy;

import com.base.ExergyAuthenticatedBase;
import com.base.ExergyUsers;
import com.exergy.pages.CapturePolicyPage;
import com.exergy.pages.EditClientPage;
import com.exergy.utils.PageType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.exergy.constants.CapturePolicyConstants.*;

public class CapturePolicyTests extends ExergyAuthenticatedBase {

    @Epic("Onboarding")
    @Feature("Capture Policy")
    @Story("Creating new policy")
    @Test(dataProviderClass = CapturePolicyData.class, dataProvider = "userData",
            description = "Adding new policy")
    public void checkPolicyCreation(ExergyUsers exergyUsers) {
        CapturePolicyPage capturePolicyPage = navigateTo(PageType.CAPTURE_POLICY);
        capturePolicyPage
                .createRandomClient()
                .checkPolicyNumberGenerated()
                .clickIsFixedCheckbox()
                .addBenefitDetails(PREMIUM_COVERED)
                .addPaymentDetails(CASH)
                .addBeneficiaryDetails()
                .addComission();
        EditClientPage editClientPage = capturePolicyPage
                .clickOnProposerLink();
        editClientPage
                .selectClientAdditionalDetails();
        capturePolicyPage = new CapturePolicyPage(page);
        capturePolicyPage
                .clickOnValidateButtonCheckError()
                .checkMedicalReqCheckboxes()
                .clickOnValidateButton()
                .checkPolicyCreationMessage();
    }

    @Epic("Onboarding")
    @Feature("Capture Policy")
    @Story("Creating new policy")
    @Test(dataProviderClass = CapturePolicyData.class, dataProvider = "userData",
            description = "Verify Add new client pop up")
    public void checkNewPolicyCreationPopup(ExergyUsers exergyUsers) {
        CapturePolicyPage capturePolicyPage = navigateTo(PageType.CAPTURE_POLICY);
        capturePolicyPage
                .checkAddPolicyPopup();
    }

    @Epic("Onboarding")
    @Feature("Capture Policy")
    @Story("Creating new policy")
    @Test(dataProviderClass = CapturePolicyData.class, dataProvider = "userData",
            description = "Verify Client radio option is selected")
    public void checkClientRadioOption(ExergyUsers exergyUsers) {
        CapturePolicyPage capturePolicyPage = navigateTo(PageType.CAPTURE_POLICY);
        capturePolicyPage
                .checkClientRadioSelected();
    }
}
