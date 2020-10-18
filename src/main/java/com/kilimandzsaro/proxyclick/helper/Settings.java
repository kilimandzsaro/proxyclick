package com.kilimandzsaro.proxyclick.helper;

import io.github.cdimascio.dotenv.Dotenv;

public class Settings {
    
    private Dotenv dotenv;

    public Settings() {
        this.dotenv = Dotenv.load();
    }

    public String getAdminUser() {
        return dotenv.get("ADMIN_USER");
    }

    public String getAdminPassword() {
        return dotenv.get("ADMIN_PASSWORD");
    }

    public String getBaseURL() {
        return dotenv.get("BASE_URL");
    }

    public String getChromeDriverPath() {
        return dotenv.get("CHROMEDRIVER_PATH");
    }
}
