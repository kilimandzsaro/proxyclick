package com.kilimandzsaro.proxyclick.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import com.kilimandzsaro.proxyclick.helper.Settings;
import com.kilimandzsaro.proxyclick.page.Page;

public class BaseTest {

    private EventFiringWebDriver driver;
    private Settings settings;
    protected Page homePage;

    @BeforeSuite
    public void setUp() {
        this.settings = new Settings();
        System.setProperty("webdriver.chrome.driver", settings.getChromeDriverPath());
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.get(settings.getBaseURL());
        homePage = new Page(driver);
    }

    @BeforeTest
    public void setITextContextDriver(ITestContext context) {
        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		if (driver != null) {
			driver.quit();
		}
	}

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        
        // Disabling Chrome notification bar
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-ios-password-suggestions");
        options.addArguments("--disable-web-security");
        
        // Disabling the password save option
        Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);

        // Disabling Chrome notification bar at the top of the browser saying "Chrome is being controlled by automated test software"
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        
        //options.setHeadless(true);
        
        return options;
    }
}
