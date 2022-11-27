package com.ex.ui.pages.admin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By myAccountLink = By.xpath("//a[contains(text(),'My Account')]");
    private By acceptCookies = By.xpath("//div[@id='cookiescript_accept']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public MainPage clickOnAcceptCookies(){
        waitForElementClickable(webDriver,acceptCookies).click();
        waitForElementDisappear(acceptCookies, webDriver, 2);
        return this;
    }

    @Step("Click on my account link step")
    public LoginPage clickOnMyAccountLink() {
        waitForElementClickable(webDriver, myAccountLink).click();
        log.info("Click on my account link STEP");
        return new LoginPage(webDriver);
    }


}
