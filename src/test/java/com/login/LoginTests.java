package com.login;

import com.base.AuthenticatedBasse;
import com.base.ExergyUsers;
import com.exergy.pages.DashboardPage;
import com.exergy.utils.PageType;
import org.testng.annotations.Test;

public class LoginTests extends AuthenticatedBasse {

    @Test(dataProviderClass = LoginUserData.class, dataProvider = "userData")
    public void checkUserLogin(ExergyUsers exergyUsers) {
        DashboardPage dashboardPage = navigateTo(PageType.DASHBOARD);
        dashboardPage.verifyDashboardNavigation();
    }
}
