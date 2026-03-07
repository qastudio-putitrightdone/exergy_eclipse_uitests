package com.policy_search;

import com.base.ExergyUsers;
import org.testng.annotations.DataProvider;

public class PolicySearchData {

    @DataProvider(name = "userData")
    public Object[][] exergyData() {
        return new Object[][] {{new ExergyUsers("OtariD", "password")}};
    }
}
