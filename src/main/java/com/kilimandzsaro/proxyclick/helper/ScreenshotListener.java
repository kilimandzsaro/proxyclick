package com.kilimandzsaro.proxyclick.helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Step;

public class ScreenshotListener extends TestListenerAdapter {

    @Step("Test-NG Listener")
	@Override
	public void onTestFailure(ITestResult testResult) {
        System.out.println("-- Failure Handler --");
        System.out.println(testResult.getTestContext().getAttribute("driver"));
		setScreenshot(testResult);
	}

	public void setScreenshot(ITestResult result) {
        Screenshot screenshot = new Screenshot((WebDriver)result.getTestContext().getAttribute("driver"));
		screenshot.capturePageScreenshot(result.getTestName());
	}

}
