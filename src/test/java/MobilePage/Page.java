package MobilePage;

import Functions.PhoneFunctions;
import io.appium.java_client.android.AndroidDriver;

public class Page extends PhoneFunctions {

    public Page(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToElectronics() {
        goToMenu("ELEKTRONIK_BTN");
    }

    public void navigateToPhoneAccessories() {
        goToMenuScroll("TELEFON_AKSESUAR");
    }

    public void performProductSearch(String productName) {
        searchProduct("SEARCH_BAR", productName);
    }

    public void displayFirstProductInfo() {
        displayFirstProduct("PRODUCT_BOX", "PRODUCT_PRICE");
    }
}
