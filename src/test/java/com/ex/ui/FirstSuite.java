package com.ex.ui;

import com.ex.ui.pages.admin.MainPage;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class FirstSuite extends BaseTest {
    @Severity(SeverityLevel.BLOCKER)
    @Flaky
    @Test
    public void testLoginForm() {
        new MainPage(webDriver.get(), "https://www.gurock.com/testrail/")
                .clickOnAcceptCookies()
                .clickOnMyAccountLink()
                .inputEmail("qwertyasd@mailforspam.com")
                .inputPassword("Gol19121211_nvbg")
                .clickOnLoginButton()
                .verifyPasswordFieldIsEmpty();
        log.info("Test testLoginForm finished success");
    }
}
