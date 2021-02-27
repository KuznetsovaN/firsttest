import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources"},
        glue = {"steps"},
        plugin = {"util.AllureReport"},
        tags={"@3"})

public class CucumberRunner {
}
