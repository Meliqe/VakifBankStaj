package HepsiburadaTest;

import Functions.BaseMethods;
import Base.DriverManager;
import Functions.LogFunction;
import Page.PhoneFunctions;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class HepsiburadaTest{
    private Scenario scenario;
    private AndroidDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    public HepsiburadaTest() {
       this.driver= DriverManager.getDriver();
    }

    @Given("Kullanıcı mobil uygulamaya girer")
    public void uygulamaBaslatildi(){
        try{
            LogFunction.logStepResult(scenario, "Kullanıcı siteye gidiyor");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("{string}'a tıklar")
    public void aramaButonunaTikla(String jsonParameterName){
        try{
            BaseMethods baseMethods = new BaseMethods();
            baseMethods.click(jsonParameterName);
            LogFunction.logStepResult(scenario, "Arama baslatildi");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @And("Kullancı {string}'a {string} yazar")
    public void aramaKutusunaSamsungYazar(String jsonParameterName,String urun) {
        try{
            BaseMethods baseMethods=new BaseMethods();
            baseMethods.search(jsonParameterName,urun);
            LogFunction.logStepResult(scenario, "Kullanıcı " + urun + " araması yapar");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("Gelen ürünlerden ilkinin {string} ve {string} alır")
    public void ilkUrunIsimVeFiyat(String productName,String productPrice)
    {
        try{
            PhoneFunctions phoneFunctions =new PhoneFunctions();
            phoneFunctions.displayFirstProduct(productName,productPrice);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
