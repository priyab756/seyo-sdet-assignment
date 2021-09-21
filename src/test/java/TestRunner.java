
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue={"Stepdef"},
        dryRun = false,
        monochrome = true,
        format = {"pretty", "html:target/Destination"}

)

public class TestRunner  {

}