import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotOnFailure extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        captureScreenshot(tr.getName());
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] captureScreenshot(String methodName) {
        return ((TakesScreenshot) BaseTest.driver.get()).getScreenshotAs(OutputType.BYTES);
    }
}