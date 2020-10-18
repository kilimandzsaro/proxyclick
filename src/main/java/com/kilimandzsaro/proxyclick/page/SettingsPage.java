package com.kilimandzsaro.proxyclick.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.yandex.qatools.allure.annotations.Step;

public class SettingsPage extends Page {

    // WebElements
    @FindBy(xpath = "//svg[@class='icon-settings-32']")
    private WebElement settingsMenu;

    @FindBy(xpath = "//a[@translate='vm_settings_tab_logbook']")
    private WebElement logbook;
    private String logbookSettingsMenuCheck = "//a[@translate='vm_settings_tab_logbook']";

    @FindBy(xpath = "//button[@translate='vm_settings_customFields_add_button']")
    private WebElement newCustomField;
    private String newCustomFieldButton = "//button[@translate='vm_settings_customFields_add_button']";

    @FindBy(name = "name")
    private WebElement customFieldName;
    private String nameField = "name";

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement customFieldHiddenElement;
    private String hiddenElementCheckbox = "//input[@type='checkbox']";

    @FindBy(xpath = "//button[@text='Save']")
    private WebElement customFieldSave;
    private String logbookSettingsPageCheck = "//div[@translate='vm_settings_logbook_visitCreation_title']";
    
    public SettingsPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
    }
    
    // Methods
    @Step
    public WebDriver goLogbookSettings() {
        webDriver.get(trimDashboardFromURL(webDriver.getCurrentUrl()) + "/settings/visit");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(newCustomFieldButton)));

        return webDriver;
    }

    @Step
    public WebDriver createLogbookCustomField() {
        newCustomField.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameField)));

        return webDriver;
    }

    @Step
    public WebDriver fillHiddenLogbookCustomFieldName(String name) {
        customFieldName.sendKeys(name);

        return webDriver;
    }

    @Step
    public WebDriver selectHiddenLogbookCustomField() {
        customFieldHiddenElement.click();

        return webDriver;
    }

    @Step
    public WebDriver saveNewCustomField() {
        customFieldSave.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(logbookSettingsPageCheck)));

        return webDriver;
    }

    @Step
    public Boolean isSettingsPageLoaded() {
        if (newCustomField.isDisplayed()) {
            return true;
        }

        return false;
    }

    @Step
    public Boolean isCreateCustomWindowLoaded() {
        if (customFieldName.isDisplayed()) {
            return true;
        }

        return false;
    }

    @Step
    public Boolean isHiddenFieldSelected() {
        if (webDriver.findElement(By.xpath(hiddenElementCheckbox)).isSelected()) {
            return true;
        }

        return false;
    }

    @Step
    public Boolean isCustomFieldExist(String customFieldName) {
        List<WebElement> tr = webDriver.findElements(By.xpath("//td[@class='ellipsed ng-binding']/"));
        for (WebElement e : tr) {
            if (e.getText() == customFieldName) {
                return true;
            }
        }

        return false;
    }

    private String trimDashboardFromURL(String url) {
        if (url.endsWith("/dashboard")) {
            return url.replaceFirst("/dashboard", "/");
        }

        return url;
    }
    
}
