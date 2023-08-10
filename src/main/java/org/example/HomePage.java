package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;


public class HomePage extends BasePage {
    By searchIcon = By.cssSelector("summary[aria-label='Search']");
    By searchBar = By.id("Search-In-Modal");
    By searchResults = By.cssSelector("li[id^='predictive-search-option'] a");

    // Scoped Element
    By productName = By.cssSelector(".predictive-search__item-heading");

    public HomePage (WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage search(String searchItem) {
        webDriver.findElement(searchIcon).click();
        webDriver.findElement(searchBar).sendKeys(searchItem);
        return this;
    }

    public List<Item> getSearchItems() {
        List <WebElement> elements = waits.waitUntilAllElementsAreVisible(searchResults);
        List<Item> items = new ArrayList<>();
        for(WebElement element : elements) {
            String name = element.findElement(productName).getText();
            Item item = new Item();
            item.setName(name);
            items.add(item);
        }
        return items;
    }
    public int getItemCount(){
        return 0;
    }
}