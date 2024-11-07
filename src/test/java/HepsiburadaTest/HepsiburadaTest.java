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
        LogFunction.logStepResult(scenario, "Kullanıcı siteye gidiyor");
    }

    @When("Kullanıcı elektronik tuşuna basar")
    public void kullaniciElektronikTusunaBasar() {
        hepsiburadaPage.navigateToElectronics();
        LogFunction.logStepResult(scenario, "Kullanıcı elektronik tuşuna basar");
    }

    @And("Kullanıcı telefon ve aksesuarlar kategorisine gider")
    public void kullaniciTelefonVeAksesuarlarKategorisineGider() {
        hepsiburadaPage.navigateToPhoneAccessories();
        LogFunction.logStepResult(scenario, "Kullanıcı telefon ve aksesuarlar kategorisine gider");
    }

    @And("Kullanıcı {string} araması yapar")
    public void kullaniciAramasiYapar(String urun) {
        hepsiburadaPage.performProductSearch(urun);
        LogFunction.logStepResult(scenario, "Kullanıcı " + urun + " araması yapar");
    }

    @Then("İlk ürünün adını ve fiyatını görüntüler")
    public void ilkUrununAdiniVeFiyatiniGoruntuler() {
        hepsiburadaPage.displayFirstProductInfo();
        LogFunction.logStepResult(scenario, "İlk ürünün adını ve fiyatını görüntüler");
    }
}
