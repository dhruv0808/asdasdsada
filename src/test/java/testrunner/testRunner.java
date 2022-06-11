package testrunner;


import org.testng.annotations.Listeners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(// 
		tags = "@tag1",
        features = "src/test/resources/features",
        glue = "stepdef")

@Listeners(resources.Listeners.class)
public class testRunner extends AbstractTestNGCucumberTests {

}
