import driver.DriverCreator;
import org.example.Customer;
import org.example.LauncherPage;
import org.example.Product;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BuyAProductTests {

    @Test(groups = "wip")
    public void verifyThatFirstTimeUserIsAbleToBuyAProduct() {
        //Arrange
        Customer newCustomer = new Customer().init();
        Product productToBuy = new Product().init();
        WebDriver driver = new DriverCreator().create("chrome");
        new LauncherPage(driver).navigateTo("");

        //Act
        //....
    }

}