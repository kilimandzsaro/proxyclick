package com.kilimandzsaro.proxyclick.page;

import com.kilimandzsaro.proxyclick.helper.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends Page {
	
	// WebElements
	@FindBy(xpath = "//input[@type='text']")
	private WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginbtn;

	@FindBy(xpath = "//a[@class='no-link dropdown-toggle pxc-pointer pxc-header__company-switch-btn']")
	private WebElement locationSelector;

	@FindBy(xpath = "//a[@title='Corp JRM Bakos']")
	private WebElement testCorpLocation;

	@FindBy(xpath = "//a[@uib-tooltip='Logbook']")
	private WebElement dashboard;

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	//Methods
	@Step
	public WebDriver login(String uName, String passw){
		// put extra step to load the page
		webDriver.getPageSource();

		userName.sendKeys(uName);
		password.sendKeys(passw);
		loginbtn.click();

		return webDriver;
	}

	@Step
	public WebDriver loginAsAdmin() {
		// Login as admin
		login(settings.getAdminUser(), settings.getAdminPassword());

		// Wait until it logged in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@uib-tooltip='Logbook']")));

		// Select the test corp location
		locationSelector.click();
		testCorpLocation.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@uib-tooltip='Logbook']")));

		return webDriver;
	}

	@Step
	public Boolean isLogin() {
		if (dashboard.isDisplayed()) {
			return true;
		}

		return false;
	}

}
