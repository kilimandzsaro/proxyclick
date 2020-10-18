package com.kilimandzsaro.proxyclick.custom_field;

import java.time.LocalTime;

import com.kilimandzsaro.proxyclick.base.BaseTest;
import com.kilimandzsaro.proxyclick.page.LoginPage;
import com.kilimandzsaro.proxyclick.page.SettingsPage;

import org.testng.annotations.Test;

public class CreateCustomField extends BaseTest {
    
    @Test
    public void testSuccessHiddenLogbookCustomFieldCreate() {
        LocalTime time = LocalTime.now();
        String customFieldName = "Auto new hidden field" + time;

        // login to the page as admin
        LoginPage login = new LoginPage(homePage.getWebDriver());
        login.loginAsAdmin();
        assert login.isLogin();

        // go to settings logbook
        SettingsPage setPage = new SettingsPage(homePage.getWebDriver());
        setPage.goLogbookSettings();
        assert setPage.isSettingsPageLoaded();

        // press to the create custom field
        setPage.createLogbookCustomField();
        assert setPage.isCreateCustomWindowLoaded();

        // fill the name
        setPage.fillHiddenLogbookCustomFieldName(customFieldName);
        
        // select hidden field
        setPage.selectHiddenLogbookCustomField();
        assert setPage.isHiddenFieldSelected();

        // create field
        setPage.saveNewCustomField();
        assert setPage.isCustomFieldExist(customFieldName);
    }
}
