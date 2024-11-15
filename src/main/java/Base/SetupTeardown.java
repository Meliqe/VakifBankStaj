package Base;

import Functions.ScreenShotFunction;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class SetupTeardown {


    @Parameters("deviceIndex")
    @BeforeClass
    public void startDriver(String deviceIndex) {
        try {
            if (deviceIndex == null || deviceIndex.trim().isEmpty()) {
                throw new RuntimeException("deviceIndex parametresi alınamadı.");
            }
            System.out.println("Device Index: " + deviceIndex);
            DriverManager.setDriver(deviceIndex);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Driver başlatılamadı: " + e.getMessage());
        }
    }


    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                AndroidDriver driver = DriverManager.getDriver();
                String scenarioName = scenario.getName();
                ScreenShotFunction.takeScreenshotAfterStep(driver, scenario, scenarioName);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Ekran görüntüsü alınamadı: " + e.getMessage());
            }
        }
    }

    @After
    public void stopDriver(Scenario scenario) {
        try {
            DriverManager.quitDriver();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Driver kapatılırken hata oluştu: " + e.getMessage());
        }
    }
}
