package MobilePage;

import Functions.PhoneFunctions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Page extends PhoneFunctions {

    public static final By ELEKTRONIK_BTN = By.xpath("//android.widget.ImageView[@content-desc='elektronik ürünlerde fırsatları kaçırma']");
    public static final By TELEFON_AKSESUAR = By.xpath("//android.widget.TextView[contains(@text, 'Telefon & Aksesuar')]");
    public static final By SEARCH_BAR = By.xpath("//android.widget.EditText");
    public static final By PRODUCT_BOX = By.xpath("//android.widget.TextView[@text='Samsung']");
    public static final By PRODUCT_PRICE = By.xpath(".//android.widget.TextView[contains(@text, 'Satış Fiyatı')]");



    public Page(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToElectronics() {
        goToMenu(ELEKTRONIK_BTN);
    }

    public void navigateToPhoneAccessories() {
        goToMenu(TELEFON_AKSESUAR);
    }

    public void performProductSearch(String urun) {
        searchProduct(SEARCH_BAR, urun);
    }

    public void displayFirstProductInfo() {
        printFirstProductInfo(PRODUCT_BOX, PRODUCT_PRICE);
    }
}
