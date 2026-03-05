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
    @Test(dataProviderClass = CapturePolicyData.class, dataProvider = "userData")
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
}
