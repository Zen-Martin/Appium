import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:test-output.html"},
        features = {"src/test/resources"},
        glue = {"com.dior.steps_definition"},
        monochrome = true
)
public class TestRunner {

}
