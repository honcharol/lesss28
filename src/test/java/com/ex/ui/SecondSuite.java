package com.ex.ui;

import com.ex.ui.pages.admin.MainPage;
import org.testng.annotations.Test;

public class SecondSuite extends BaseTest {
    @Test
    public void testLoginForm2() {
        new MainPage(webDriver.get(), "https://www.gurock.com/testrail/")
            .clickOnMyAccountLink()
            .inputEmail("qwertyasd@mailforspam.com")
            .inputPassword("Gol19121211_nvbg")
            .clickOnLoginButton()
            .verifyPasswordFieldIsEmpty();
        log.info("Test testLoginForm finished success");
    }
}
