import org.example.HomePage;
import org.example.Item;
import org.example.LauncherPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchTests {
    @Test
    public void verifyIfSearchTermShowsRelevantResults() throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();
        try { //Arrange
            String searchItem = "Product";
            String searchKey = "Product";
            LauncherPage launcherPage = new LauncherPage(webDriver);
            launcherPage.navigateTo("https://web-playground.ultralesson.com/");

            //Act
            HomePage homepage = new HomePage(webDriver);
            homepage.search(searchItem);
            List<Item> searchItems = homepage.getSearchItems();

            //Assert
            Assert.assertEquals(0, searchItems.size());
            Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));
        } catch (Exception e) {
            System.out.println("Al-Fareed : Error .." + e.getMessage());
        } finally {
            webDriver.quit();
        }
    }

    @Test
    public void verifySearchUnavailableProduct() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        try {  // Arrange
            String unavailableProduct = "Unobtainium Widget";

            LauncherPage launcherPage = new LauncherPage(webDriver);
            launcherPage.navigateTo("https://web-playground.ultralesson.com/");

            // Act
            HomePage homepage = new HomePage(webDriver);
            homepage.search(unavailableProduct);
            List<Item> searchItems = homepage.getSearchItems();

            // Assert
            Assert.assertTrue(searchItems.isEmpty());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            webDriver.quit();
        }
    }

    @Test
    public void verifyBrandSearchListsOnlyBrandItems() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        try { // Arrange
            String brandName = "Nike";

            LauncherPage launcherPage = new LauncherPage(webDriver);
            launcherPage.navigateTo("https://web-playground.ultralesson.com/");

            // Act
            HomePage homepage = new HomePage(webDriver);
            homepage.search(brandName);
            List<Item> searchItems = homepage.getSearchItems();

            // Assert
            Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(brandName)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            webDriver.quit();
        }
    }

    @Test
    public void verifySearchResultCountMatchesDisplayedItems() {
        // Arrange
        String searchItem = "Shoes";
        WebDriver webDriver = new ChromeDriver();

        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        // Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();
        int itemCountDisplayed = homepage.getItemCount(); // Assume getItemCount method returns the number displayed on the page

        // Assert
        Assert.assertEquals(searchItems.size(), itemCountDisplayed);

        webDriver.quit();
    }

}