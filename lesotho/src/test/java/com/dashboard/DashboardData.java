package com.dashboard;

import com.base.ExergyUsers;
import org.testng.annotations.DataProvider;

public class DashboardData {

    @DataProvider(name = "userData")
    public Object[][] exergyData() {
        return new Object[][] {{new ExergyUsers("Shubham", "Shubham_123")}};
    }
}
