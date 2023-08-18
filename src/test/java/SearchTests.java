import driver.DriverCreator;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.example.HomePage;
import org.example.Item;
import org.example.LauncherPage;
import org.example.Product;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

@Epic("Search")
@Feature("Relevant Search")
public class SearchTests {

    @Test(description = "When a user searches with a keyword, relevant results for the keyword should be displayed to the user.")
    @Story("Verify If Search Term Shows Relevant Results")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyIfSearchTermShowsRelevantResults() {
        //Arrange
        String searchItem = "Jeans";
        String searchKey = "Jean";
        String browser = "chrome";
//        WebDriver webDriver = new DriverCreator().create(browser);
////        LauncherPage launcherPage = new LauncherPage(webDriver);
////        launcherPage.navigateTo("https://web-playground.ultralesson.com/");
//        webDriver.get("https://web-playground.ultralesson.com/");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchProducts = homepage.getSearchItems();

        //Assert
        Assert.assertEquals(searchProducts.size(), searchProducts.size());
        Assert.assertTrue(searchProducts.stream().allMatch(product -> product.getName().contains(searchKey)));
    }
}

