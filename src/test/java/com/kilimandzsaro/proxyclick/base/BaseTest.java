package com.kilimandzsaro.proxyclick.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.kilimandzsaro.proxyclick.helper.Settings;
import com.kilimandzsaro.proxyclick.page.Page;

public class BaseTest {

    private EventFiringWebDriver driver;
    private Settings setting;
    protected Page homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/recources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        startTest();
    }

    @BeforeMethod
    public void startTest() {
        driver.get(setting.getBaseURL());
        homePage = new Page(driver);

        //1 - Maximize the window
        //driver.manage().window().maximize();

        //2 - Fullscreen mode
        driver.manage().window().fullscreen();

        //3 - Specific width (iPhoneX)
        //driver.manage().window().setSize(new Dimension(375, 812));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // Disabling Chrome notification bar at the top of the browser saying "Chrome is being controlled by automated test software"
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //options.setHeadless(true);
        return options;
    }
}
