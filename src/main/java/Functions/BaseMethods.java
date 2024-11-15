package Functions;

import Base.DriverManager;
import Base.LocatorUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Base.WaitUtil.waitUntilVisibleByLocator;

public class BaseMethods {
    protected AndroidDriver driver;

    public BaseMethods() {
        this.driver = DriverManager.getDriver();
    }
    public void click(String locatorKey) {
        try {
            By locator = LocatorUtils.getLocator(locatorKey);
            WebElement element = waitUntilVisibleByLocator(driver, locator);
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu (click): " + e.getMessage());
        }
    }

    public void search(String locatorKey, String text) {
        try {
            By locator = LocatorUtils.getLocator(locatorKey);
            WebElement searchField = waitUntilVisibleByLocator(driver, locator);
            searchField.clear();
            searchField.sendKeys(text);
            System.out.println("Arama kutusuna '" + text + "' yazıldı.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu (search): " + e.getMessage());
        }
    }

}
