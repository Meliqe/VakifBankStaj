package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class WaitUtil {

    public static WebElement waitUntilVisibleByLocator(WebDriver driver, By locator) {
        WebElement element = null;
        try {
            element = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(org.openqa.selenium.NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element bulunamadı: " + e.getMessage());
        }
        return element;
    }
}
