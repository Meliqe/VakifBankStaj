package Functions;

import Utility.LocatorUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utility.WaitUtil.waitUntilVisibleByLocator;

public class BaseMethods {
    protected AndroidDriver driver;

    public BaseMethods(AndroidDriver driver) {
        this.driver = driver;
    }

    public void click(String locatorKey) {
        try {
            By locator = LocatorUtils.getLocator(locatorKey);
            WebElement element = waitUntilVisibleByLocator(driver, locator);
            if (element != null) {
                element.click();
                System.out.println(locatorKey + " öğesine tıklandı.");
            } else {
                throw new AssertionError(locatorKey + " öğesi görünür değil.");
            }
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

    public void getFirstElementInfo(String productKey, String priceKey) {
        try {
            By productLocator = LocatorUtils.getLocator(productKey);
            By priceLocator = LocatorUtils.getLocator(priceKey);

            WebElement firstProduct = driver.findElement(productLocator);
            WebElement priceElement = firstProduct.findElement(priceLocator);

            System.out.println("İlk Ürün Adı: " + firstProduct.getText());
            System.out.println("İlk Ürün Fiyatı: " + priceElement.getText());
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu (getFirstElementInfo): " + e.getMessage());
        }
    }
}
