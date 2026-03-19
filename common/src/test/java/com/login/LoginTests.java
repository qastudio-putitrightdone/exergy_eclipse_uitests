package com.login;

import com.base.ExergyAuthenticatedBase;
import com.base.ExergyUsers;
import com.exergy.pages.DashboardPage;
import com.exergy.utils.PageType;
import org.testng.annotations.Test;

public class LoginTests extends ExergyAuthenticatedBase {

    @Test(dataProviderClass = LoginUserData.class, dataProvider = "userData")
    public void checkUserLogin(ExergyUsers exergyUsers) {
        DashboardPage dashboardPage = navigateTo(PageType.DASHBOARD);
        dashboardPage.verifyDashboardNavigation();
    }
}
