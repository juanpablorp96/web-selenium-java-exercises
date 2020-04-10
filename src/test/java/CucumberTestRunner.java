import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = {"./src/test/java/features/"},
        glue = {"stepDefinitions"},
        monochrome = true
        )
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
