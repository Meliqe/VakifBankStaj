package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private static String deviceIndex;

    public static void setDriver(String deviceIndex) {
        if (driver.get() == null) {
            DriverManager.deviceIndex = deviceIndex;
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName(ConfigReader.getProperty("device" + deviceIndex + ".platformName"));
                options.setPlatformVersion(ConfigReader.getProperty("device" + deviceIndex + ".platformVersion"));
                options.setDeviceName(ConfigReader.getProperty("device" + deviceIndex + ".deviceName"));
                options.setAppPackage(ConfigReader.getProperty("device" + deviceIndex + ".appPackage"));
                options.setAppActivity(ConfigReader.getProperty("device" + deviceIndex + ".appActivity"));
                options.setAutomationName("UiAutomator2");
                options.setNewCommandTimeout(Duration.ofSeconds(3600));
                options.setAutoGrantPermissions(true);
                options.setApp(ConfigReader.getProperty("device" + deviceIndex + ".app"));
                options.setFullReset(true);

                String appiumServerURL = ConfigReader.getProperty("device" + deviceIndex + ".appiumServerURL");

                AndroidDriver driverInstance = new AndroidDriver(new URL(appiumServerURL), options);
                driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                driver.set(driverInstance);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Driver başlatılamadı: " + e.getMessage());
            }
        }
    }

    public static AndroidDriver getDriver() {
        if (driver.get() == null && deviceIndex != null) {
            setDriver(deviceIndex);
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
