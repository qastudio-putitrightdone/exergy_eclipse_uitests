package com.policy_search;

import com.base.ExergyAuthenticatedBase;
import com.base.ExergyUsers;
import com.exergy.pages.PolicySearchPage;
import com.exergy.utils.PageType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.exergy.constants.CapturePolicyConstants.BOTSHELO_WHOLE_LIFE;

public class PolicySearchTests extends ExergyAuthenticatedBase {

    @Epic("Policy Search")
    @Feature("Policy Search")
    @Story("Policy Search")
    @Test(dataProviderClass = PolicySearchData.class, dataProvider = "userData",
    description = "Check policy page navigation")
    public void checkPolicySearchPageNavigation(ExergyUsers exergyUsers) {
        PolicySearchPage policySearchPage = navigateTo(PageType.POLICY_SEARCH);
        policySearchPage
                .validatePolicySearchPagNavigation();
    }

    @Epic("Policy Search")
    @Feature("Policy Search")
    @Story("Policy Search")
    @Test(dataProviderClass = PolicySearchData.class, dataProvider = "userData",
            description = "Check search policy functionality")
    public void checkSearchPolicy(ExergyUsers exergyUsers) {
        PolicySearchPage policySearchPage = navigateTo(PageType.POLICY_SEARCH);
        policySearchPage
                .validatePolicySearchPagNavigation()
                .selectProductValue(BOTSHELO_WHOLE_LIFE)
                .clickOnSearchButton()
                .checkSearchedValueAvailableInTable(BOTSHELO_WHOLE_LIFE);
    }

    @Epic("Policy Search")
    @Feature("Policy Search")
    @Story("Policy Search")
    @Test(dataProviderClass = PolicySearchData.class, dataProvider = "userData",
            description = "Check default search behaviour")
    public void checkNoSearchAvailableDefault(ExergyUsers exergyUsers) {
        PolicySearchPage policySearchPage = navigateTo(PageType.POLICY_SEARCH);
        policySearchPage
                .validatePolicySearchPagNavigation()
                .checkNoResultReturnedDisplayed();
    }

    @Epic("Policy Search")
    @Feature("Policy Search")
    @Story("Policy Search")
    @Test(dataProviderClass = PolicySearchData.class, dataProvider = "userData",
            description = "Check default search click behaviour")
    public void checkSearchClickReturnValues(ExergyUsers exergyUsers) {
        PolicySearchPage policySearchPage = navigateTo(PageType.POLICY_SEARCH);
        policySearchPage
                .validatePolicySearchPagNavigation()
                .clickOnSearchButton()
                .checkSearchResultsAvailable();
    }
}
