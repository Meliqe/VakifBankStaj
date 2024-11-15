package HepsiburadaTest;

import Functions.BaseMethods;
import Base.DriverManager;
import Functions.LogFunction;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class HepsiburadaTest{
    private Scenario scenario;
    private AndroidDriver driver;

    public HepsiburadaTest() {
       this.driver= DriverManager.getDriver();
    }

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("Kullanıcı siteye gider")
    public void uygulamaBaslatildi() {
        try{
            LogFunction.logStepResult(scenario, "Kullanıcı siteye gidiyor");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("Kullanıcı {string} tuşuna basar")
    public void kullaniciElektronikTusunaBasar(String jsonParameterName) {
        try{
            BaseMethods baseMethods=new BaseMethods();
            baseMethods.click(jsonParameterName);
            LogFunction.logStepResult(scenario, "Kullanıcı elektronik tuşuna basar");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @And("Kullanıcı {string} kategorisine gider")
    public void kullaniciTelefonVeAksesuarlarKategorisineGider(String jsonParameterName) {
        try{
            BaseMethods baseMethods=new BaseMethods();
            baseMethods.click(jsonParameterName);
            LogFunction.logStepResult(scenario, "Kullanıcı telefon ve aksesuarlar kategorisine gider");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @And("Kullanıcı {string}'a {string} yazar")
    public void kullaniciAramaYapar(String jsonParameterName,String urun) {
        try{
            BaseMethods baseMethods=new BaseMethods();
            baseMethods.search(jsonParameterName,urun);
            LogFunction.logStepResult(scenario, "Kullanıcı " + urun + " araması yapar");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("İlk ürünün adını ve fiyatını görüntüler")
    public void ilkUrununAdiniVeFiyatiniGoruntuler() {

    }
}
