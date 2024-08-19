package step_definitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {


	@Before
	public void setup() {
		
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		
	}
	
	
	@After
	public void wrapup( Scenario scenario) {
		
		if (scenario.isFailed()) {
			
			byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(screenshot, "image/png", "screenshot");
			
		}
		
		Driver.quitDriver();
		
		
		
	}
	
}
