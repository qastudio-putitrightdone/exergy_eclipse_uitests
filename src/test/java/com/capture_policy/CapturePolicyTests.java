package com.capture_policy;

import com.base.ExergyAuthenticatedBase;
import com.base.ExergyUsers;
import com.exergy.pages.CapturePolicyPage;
import com.exergy.utils.PageType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.exergy.constants.CapturePolicyConstants.*;

public class CapturePolicyTests extends ExergyAuthenticatedBase {

    @Epic("Onboarding")
    @Feature("Capture Policy")
    @Story("Add Client")
    @Test(dataProviderClass = CapturePolicyData.class, dataProvider = "userData")
    public void checkClientCreation(ExergyUsers exergyUsers) {
        CapturePolicyPage capturePolicyPage = navigateTo(PageType.CAPTURE_POLICY);
        capturePolicyPage
                .createRandomClient()
                .checkPolicyNumberGenerated()
                .clickIsFixedCheckbox()
                .addBenefitDetails(PREMIUM_COVERED)
                .addPaymentDetails(CASH)
                .addBeneficiaryDetails()
                .addComission()
                .clickOnValidateButton();
    }
}
