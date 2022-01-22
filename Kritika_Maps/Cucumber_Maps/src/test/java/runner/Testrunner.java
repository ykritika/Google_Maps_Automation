package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/java/features"
		,glue= "stepDefinition"
		
		)

public class Testrunner extends AbstractTestNGCucumberTests{

}
 