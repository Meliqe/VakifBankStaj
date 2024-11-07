package Functions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public void searchProduct(By opportunity, By priceOption, By searchBar, String productName) {
        try {
            WebElement opportunityBtn = waitUntilVisibleByLocator(driver, opportunity);
            if (opportunityBtn != null) {
                opportunityBtn.click();
            } else {
                System.out.println("Fırsat butonu bulunamadı.");
                throw new AssertionError("Fırsat butonu bulunamadı.");
            }

            WebElement priceBtn = waitUntilVisibleByLocator(driver, priceOption);
            if (priceBtn != null) {
                priceBtn.click();
            }

            WebElement search = waitUntilVisibleByLocator(driver, searchBar);
            if (search != null) {
                search.sendKeys(productName);
                driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            } else {
                System.out.println("Arama çubuğu bulunamadı.");
                throw new AssertionError("Arama çubuğu bulunamadı.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu: " + e.getMessage());
        }
    }

    public void printFirstProductInfo(By productContainer, By productName, String priceScrollable) {
        try {
            List<WebElement> products = waitUntilVisibleByLocator(driver, productContainer) != null
                    ? driver.findElements(productContainer)
                    : null;

            if (products != null && !products.isEmpty()) {
                WebElement firstProductName = products.get(0).findElement(productName);
                System.out.println("İlk ürünün adı: " + firstProductName.getText());

                WebElement priceElement = driver.findElement(AppiumBy.androidUIAutomator(priceScrollable));
                System.out.println("İlk ürünün fiyatı: " + priceElement.getText());
            } else {
                System.out.println("Ürün bulunamadı");
                throw new AssertionError("Ürün bulunamadı.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
