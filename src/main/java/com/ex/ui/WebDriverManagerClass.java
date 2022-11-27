package com.ex.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverManagerClass {
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverManagerClass(String browser) {
        setWebDriver(browser);
    }

    private synchronized void setWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                webDriverThreadLocal.set(WebDriverManager.chromedriver().create());
                break;
            case "ff":
                webDriverThreadLocal.set(WebDriverManager.firefoxdriver().create());
                break;
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }

    public synchronized static WebDriver getWebDriver() {
        String browser = System.getProperty("browser");
//        String browser = "chrome";
        if (webDriverThreadLocal.get() == null) {
            new WebDriverManagerClass(browser);
        }
        return webDriverThreadLocal.get();
    }
}
