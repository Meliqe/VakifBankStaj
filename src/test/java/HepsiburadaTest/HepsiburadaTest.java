package HepsiburadaTest;

import MobilePage.Page;
import Utility.DriverManager;
import Functions.LogFunction;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class HepsiburadaTest {
    private Page hepsiburadaPage;
    private Scenario scenario;

    public HepsiburadaTest() {
        DriverManager.setDriver();
        hepsiburadaPage = new Page(DriverManager.getDriver());
    }

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("Kullanıcı siteye gider")
    public void uygulamaBaslatildi() {
        try {
            LogFunction.logStepResult(scenario, "Kullanıcı siteye gidiyor");
        } catch (Exception e) {
            scenario.log("Hata oluştu: " + e.getMessage());
        }
    }

    @When("Kullanıcı elektronik tuşuna basar")
    public void kullaniciElektronikTusunaBasar() {
        try {
            hepsiburadaPage.navigateToElectronics();
            LogFunction.logStepResult(scenario, "Kullanıcı elektronik tuşuna basar");
        } catch (Exception e) {
            scenario.log("Hata oluştu: " + e.getMessage());
        }
    }

    @And("Kullanıcı telefon ve aksesuarlar kategorisine gider")
    public void kullaniciTelefonVeAksesuarlarKategorisineGider() {
        try {
            hepsiburadaPage.navigateToPhoneAccessories();
            LogFunction.logStepResult(scenario, "Kullanıcı telefon ve aksesuarlar kategorisine gider");
        } catch (Exception e) {
            scenario.log("Hata oluştu: " + e.getMessage());
        }
    }

    @And("Kullanıcı {string} araması yapar")
    public void kullaniciAramasiYapar(String urun) {
        try {
            hepsiburadaPage.performProductSearch(urun);
            LogFunction.logStepResult(scenario, "Kullanıcı " + urun + " araması yapar");
        } catch (Exception e) {
            scenario.log("Hata oluştu: " + e.getMessage());
        }
    }

    @Then("İlk ürünün adını ve fiyatını görüntüler")
    public void ilkUrununAdiniVeFiyatiniGoruntuler() {
        try {
            hepsiburadaPage.displayFirstProductInfo();
            LogFunction.logStepResult(scenario, "İlk ürünün adını ve fiyatını görüntüler");
        } catch (Exception e) {
            scenario.log("Hata oluştu: " + e.getMessage());
        }
    }
}
