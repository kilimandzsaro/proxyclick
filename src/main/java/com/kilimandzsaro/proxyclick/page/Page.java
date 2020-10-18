package com.kilimandzsaro.proxyclick.page;

import com.google.common.base.Predicate;
import com.kilimandzsaro.proxyclick.helper.Screenshot;
import com.kilimandzsaro.proxyclick.helper.Settings;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public Screenshot screenshot;
	
	public WebDriverWait wait;

	public Settings settings;
	
	protected WebDriver webDriver;

	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.screenshot = new Screenshot(webDriver);
		this.wait = new WebDriverWait(webDriver, 30);
		this.settings = new Settings();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}
	
}