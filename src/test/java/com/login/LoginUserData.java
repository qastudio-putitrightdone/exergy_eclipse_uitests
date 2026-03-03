package com.login;

import com.base.ExergyUsers;
import org.testng.annotations.DataProvider;

public class LoginUserData {

    @DataProvider(name = "userData")
    public Object[][] exergyData() {
        return new Object[][] {{new ExergyUsers("OtariD", "password")}};
    }
}
