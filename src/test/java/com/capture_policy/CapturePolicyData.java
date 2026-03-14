package com.capture_policy;

import com.base.ExergyUsers;
import org.testng.annotations.DataProvider;

public class CapturePolicyData {

    @DataProvider(name = "userData")
    public Object[][] exergyData() {
                return new Object[][] {{new ExergyUsers("HandeS", "K1lim@njaro2026")}};
    }
}
