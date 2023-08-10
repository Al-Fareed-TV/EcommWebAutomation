package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class PageWaits {

    private WebDriver webDriver;
    private FluentWait wait;

    public PageWaits(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = initWait(webDriver);
    }
    public List<WebElement> waitUntilAllElementsAreVisible(By by) {
        return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement waitForElementToBePresent(By by) {
        return (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private FluentWait initWait(WebDriver webDriver) {
        return new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

}
