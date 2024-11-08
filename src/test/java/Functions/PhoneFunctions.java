package Functions;

import io.appium.java_client.android.AndroidDriver;

public class PhoneFunctions extends BaseMethods {

    public PhoneFunctions(AndroidDriver driver) {
        super(driver);
    }

    public void goToMenu(String menuKey) {
        click(menuKey);
    }

    public void goToMenuScroll(String menuKey) {
        scrollAndClick(menuKey);
    }

    public void searchProduct(String searchBarKey, String productName) {
        search(searchBarKey, productName);
    }

    public void displayFirstProduct(String productKey, String priceKey) {
        getFirstElementInfo(productKey, priceKey);
    }
}
