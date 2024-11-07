package Functions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static Utility.WaitUtil.waitUntilVisibleByLocator;

public class PhoneFunctions {
    protected AndroidDriver driver;

    public PhoneFunctions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void goToMenu(By menuButton) {
        try {
            WebElement element = waitUntilVisibleByLocator(driver, menuButton);
            if (element != null) {
                element.click();
            } else {
                System.out.println("Menu butonu bulunamadı.");
                throw new AssertionError("Menu butonu bulunamadı.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu: " + e.getMessage());
        }
    }

    public void searchProduct(By searchBar, String productName) {
        try {
            WebElement search = waitUntilVisibleByLocator(driver, searchBar);
            search.sendKeys(productName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu: " + e.getMessage());
        }
    }

    public void printFirstProductInfo(By productContainer, By productPrice) {
        try {
            List<WebElement> productBoxes = driver.findElements(productContainer);

            if (productBoxes != null && !productBoxes.isEmpty()) {
                WebElement firstProduct = productBoxes.get(0);

                WebElement priceElement = firstProduct.findElement(productPrice);

                System.out.println("İlk Ürün Fiyatı: " + priceElement.getText());
            } else {
                System.out.println("Ürün bulunamadı");
                throw new AssertionError("Ürün bulunamadı.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu: " + e.getMessage());
        }
    }
}