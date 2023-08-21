import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Rest of your setup and teardown methods...
}