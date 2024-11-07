package Functions;

import io.cucumber.java.Scenario;

public class LogFunction {

    public static void logStepResult(Scenario scenario, String stepDescription) {
        if (scenario.isFailed()) {
            scenario.log("Başarısız: " + stepDescription + " adımı başarısız oldu.");
        } else {
            scenario.log("Başarılı: " + stepDescription + " adımı başarıyla tamamlandı.");
        }
    }
}
