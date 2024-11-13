package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"HepsiburadaTest", "Base"},
        plugin = {"pretty", "html:target/cucumber-reports-testng.html", "json:target/cucumber-reports/cucumber-testng.json"},
        monochrome = true,
        dryRun = false,
        tags = "@HepsiburadaTest"
)
public class RunCucumberTestNG extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true) // Paralel çalıştırmayı sağlar
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
