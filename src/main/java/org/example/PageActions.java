package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class PageActions {
    private WebDriver webDriver;
    private PageWaits waits;

    public PageActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waits = new PageWaits(webDriver);
    }

    public void click(By by) {
        waits.waitForElementToBePresent(by).click();
    }

    public void type(By by, String value) {
        waits.waitForElementToBePresent(by).sendKeys(value);
    }
    public void navigateTo(String url) {
        webDriver.get(url);
    }

    public void refreshPage() {
        webDriver.navigate().refresh();
    }
    public void executeJS(String script, Object... args) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript(script, args);
    }
    public void takeScreenshot(String name) throws IOException {
        TakesScreenshot screenshotTaker = (TakesScreenshot) webDriver;
        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./Automated-screenshots/" + name + ".png"));
    }

}
