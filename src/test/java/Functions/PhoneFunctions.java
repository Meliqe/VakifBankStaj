package Functions;

import Utility.DriverManager;
import Utility.LocatorUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utility.WaitUtil.waitUntilVisibleByLocator;

public class PhoneFunctions {

    private AndroidDriver driver;
    public PhoneFunctions() {
        this.driver = DriverManager.getDriver();
    }

    public void displayFirstProduct(String productDesc, String productPrice) {
        try {
            By locator_Desc = LocatorUtils.getLocator(productDesc);
            By locator_Price = LocatorUtils.getLocator(productPrice);
            WebElement element_desc=waitUntilVisibleByLocator(driver,locator_Desc);
            String desc=element_desc.getText();WebElement element_price=waitUntilVisibleByLocator(driver,locator_Price);
            String price=element_price.getText();System.out.println("Desc: "+desc+", Price: "+price);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Hata oluştu (getFirstElementInfo): " + e.getMessage());
        }
    }
}
