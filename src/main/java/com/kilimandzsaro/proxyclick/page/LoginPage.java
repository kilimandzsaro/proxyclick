package com.kilimandzsaro.proxyclick.page;

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

	@FindBy(xpath = "//div[@aria-label='Open Intercom Messenger']")
	private WebElement dashboard;
	private String dashboardString = "//div[@aria-label='Open Intercom Messenger']";

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	//Methods
	@Step
	public WebDriver login(String uName, String passw){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardString)));

		// Select the test corp location
		String url = webDriver.getCurrentUrl();
		locationSelector.click();
		testCorpLocation.click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search people, companies, groups']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardString)));

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
