package com.kilimandzsaro.proxyclick.custom_field;

import com.kilimandzsaro.proxyclick.base.BaseTest;
import com.kilimandzsaro.proxyclick.page.LoginPage;

import org.testng.annotations.Test;

public class CreateCustomField extends BaseTest {
    @Test
    public void testSuccessHiddenLogbookCustomFieldCreate() {
        // login to the page as admin
        LoginPage login = new LoginPage(homePage.getWebDriver());
        login.loginAsAdmin();

        // go to settings logbook

        // press to the create custom field

        // fill the name
        
        // select hidden field

        // create field
    }
    
}
