package Functions;

import io.cucumber.java.Scenario;

public class LogFunction {

    public static void logStepResult(Scenario scenario, String stepDescription) {
            scenario.log("Başarılı: " + stepDescription + " adımı başarıyla tamamlandı.");
    }
}
