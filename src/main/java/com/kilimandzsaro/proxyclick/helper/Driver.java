package com.kilimandzsaro.proxyclick.helper;

import org.openqa.selenium.WebDriver;

public abstract class Driver {
    
    protected WebDriver webDriver;

    public Driver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
