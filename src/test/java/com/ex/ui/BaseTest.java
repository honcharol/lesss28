package com.ex.ui;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();;
    protected static Logger log = LogManager.getLogger();

    @BeforeClass
    public void setUp() {
        log.debug("This is webdriver inits");
        webDriver.set(WebDriverManagerClass.getWebDriver());
    }

    @AfterClass
    public void shutDown() {
        webDriver.get().quit();
    }
}
