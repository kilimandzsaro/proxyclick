package com.kilimandzsaro.proxyclick.page;

// import com.kilimandzsaro.proxyclick.helper.Screenshot;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	// public Screenshot screenshot;
	
	// public WebDriverWait wait;
	
	protected WebDriver webDriver;

	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
		// this.screenshot = new Screenshot(webDriver);
		// this.wait = new WebDriverWait(webDriver, 30);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

}