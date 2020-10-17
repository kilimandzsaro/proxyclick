package com.kilimandzsaro.proxyclick.page;

import com.kilimandzsaro.proxyclick.helper.Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends Page {
	
	//WebElements
	@FindBy(xpath = "//input[@placeholder=\"Email\"]")
	private WebElement userName;

	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement loginbtn;

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	//Methods
	@Step
	public WebDriver login(String uName, String passw){
		userName.sendKeys(uName);
		password.sendKeys(passw);
		loginbtn.click();
		return webDriver;
	}

	@Step
	public WebDriver loginAsAdmin() {
		Settings settings = new Settings();
		login(settings.getAdminUser(), settings.getAdminPassword());
		return webDriver;
	}

}
