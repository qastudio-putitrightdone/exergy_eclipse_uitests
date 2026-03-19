package com.dashboard;

import com.base.ExergyAuthenticatedBase;
import com.base.ExergyUsers;
import com.exergy.pages.DashboardPage;
import com.exergy.utils.PageType;
import org.testng.annotations.Test;

import static com.exergy.utils.TestDataGenerator.generateRandomNumber;

public class DashbaordTests extends ExergyAuthenticatedBase {

    @Test(dataProviderClass = DashboardData.class, dataProvider = "userData")
    public void checkPolicyRefNotFoundDisplayed(ExergyUsers exergyUsers) {
        DashboardPage dashboardPage = navigateTo(PageType.DASHBOARD);
        dashboardPage
                .verifyDashboardNavigation()
                .enterPolicyNumberInOpenPolicy(generateRandomNumber(12))
                .clickOnOpenButton()
                .checkPolicyRefNotFoundPopup();
    }
}
