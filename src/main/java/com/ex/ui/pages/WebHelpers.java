package com.ex.ui.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebHelpers {
    long timeOut = 10L;

    protected WebElement findElement(WebDriver webDriver, By locator) {
        return findElement(webDriver, locator, timeOut);
    }

    protected WebElement findElement(WebDriver webDriver, By locator, Long timeOut) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementIsVisible(WebDriver webDriver,By element, long... timeOut) {
        long time = 30;
        if (timeOut.length > 0) {
            time = timeOut[0];
        }
        return new WebDriverWait(webDriver, Duration.ofSeconds(time)).until(
                ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void waitForElementIsNotVisible(WebDriver webDriver, By locator, int timeOutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds)).until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForElementDisappear(By locator, WebDriver webDriver, long... timeOut) {
        long timeOutState = 2;
        if (timeOut.length > 0) {
            timeOutState = timeOut[0];
        }
        try {
            waitForElementIsVisible(webDriver, locator, timeOutState);
            if (webDriver.findElements(locator).size() > 0) {
                waitForElementIsNotVisible(webDriver, locator, 60);
            }
        } catch (TimeoutException e) {
        }
    }


    protected WebElement waitForElementClickable(WebDriver webDriver, By locator) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
            .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void scrollToElement(WebDriver webDriver, WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true)", webElement);
    }
}
