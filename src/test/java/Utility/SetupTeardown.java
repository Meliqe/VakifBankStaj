package Utility;

import Functions.ScreenShotFunction;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.appium.java_client.android.AndroidDriver;


public class SetupTeardown {

    @Before
    public void startDriver() {
        try {
            DriverManager.setDriver();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Driver başlatılamadı: " + e.getMessage());
        }
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            AndroidDriver driver = DriverManager.getDriver();
            String scenarioName = scenario.getName();
            ScreenShotFunction.takeScreenshotAfterStep(driver, scenario, scenarioName);
        }
    }

    @After
    public void stopDriver(Scenario scenario) {
        DriverManager.quitDriver();
    }
}
