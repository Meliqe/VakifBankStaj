package Functions;
import io.cucumber.java.Scenario;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotFunction {

    public static void takeScreenshotAfterStep(AndroidDriver driver, Scenario scenario, String screenshotName) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                byte[] resizedScreenshot = ImageUtils.resizeImage(screenshot, 50);
                scenario.attach(resizedScreenshot, "image/png", screenshotName);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Ekran görüntüsü alınamadı: " + e.getMessage());
            }
    }
}
