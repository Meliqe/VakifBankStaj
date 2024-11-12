package Base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LocatorUtils {
    private static Map<String, By> locators = new HashMap<>();

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootArray = mapper.readTree(new File("src/test/resources/locators.json"));

            for (JsonNode node : rootArray) {
                String key = node.get("key").asText();
                String locatorType = node.get("locatorType").asText();
                String value = node.get("value").asText();

                By locator;
                switch (locatorType.toLowerCase()) {
                    case "id":
                        locator = By.id(value);
                        break;
                    case "xpath":
                        locator = By.xpath(value);
                        break;
                    case "className":
                        locator = By.className(value);
                        break;
                    default:
                        throw new IllegalArgumentException("Geçersiz locator türü: " + locatorType);
                }
                locators.put(key, locator);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Locator dosyası yüklenemedi.");
        }
    }

    public static By getLocator(String key) {
        if (!locators.containsKey(key)) {
            throw new IllegalArgumentException("Belirtilen locator anahtarı bulunamadı: " + key);
        }
        return locators.get(key);
    }
}
