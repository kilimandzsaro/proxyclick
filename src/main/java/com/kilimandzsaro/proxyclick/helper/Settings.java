package com.kilimandzsaro.proxyclick.helper;

import io.github.cdimascio.dotenv.Dotenv;

public class Settings {
    
    Dotenv dotenv = Dotenv.load();

    public String getAdminUser() {
        return dotenv.get("ADMIN_USER");
    }

    public String getAdminPassword() {
        return dotenv.get("ADMIN_PASSWORD");
    }

    public String getBaseURL() {
        return dotenv.get("BASE_URL");
    }
}
