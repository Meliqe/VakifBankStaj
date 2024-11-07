package MobilePage;

import Functions.PhoneFunctions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Page extends PhoneFunctions {

    public static final By ELEKTRONIK_BTN = By.xpath("//android.widget.ImageView[@content-desc='elektronik ürünlerde fırsatları kaçırma']");
    public static final By TELEFON_AKSESUAR = By.xpath("//android.widget.TextView[contains(@text, 'Telefon & Aksesuar')]");
    public static final By FIRSAT = By.xpath("//android.widget.Button[@text=\"Fırsatı Kaçırma\"]");
    public static final By EN_AVANTAJLI_FIYATLAR = By.xpath("//android.widget.TextView[contains(@text, 'En Avantajlı Fiyatlar')]");
    public static final By SEARCH_BAR = By.xpath("//android.widget.EditText[@text='Ürün, kategori veya marka ara']");
    public static final By PRODUCT_BOX = By.xpath("//android.view.ViewGroup[@resource-id='com.pozitron.hepsiburada:id/clProductBoxBottom']");
    public static final By PRODUCT_NAME = By.xpath(".//android.widget.TextView[@resource-id='com.pozitron.hepsiburada:id/tvProductName']");
    public static final String PRICE_SCROLLABLE = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"com.pozitron.hepsiburada:id/tvPrice\"));";



    public Page(AndroidDriver driver) {
        super(driver);
    }

    //cucumber rapor ekle ekran görünütü aslın hata aldım mı rapora eklesin test adımlarını rapora eklesin search butonuna tıklanmıştır gibi
    //try catch ekle
    public void navigateToElectronics() {
        goToMenu(ELEKTRONIK_BTN);
    }

    public void navigateToPhoneAccessories() {
        goToMenu(TELEFON_AKSESUAR);
    }

    public void performProductSearch(String urun) {
        searchProduct(FIRSAT ,EN_AVANTAJLI_FIYATLAR, SEARCH_BAR, urun);
    }

    public void displayFirstProductInfo() {
        printFirstProductInfo(PRODUCT_BOX, PRODUCT_NAME, PRICE_SCROLLABLE);
    }
}
