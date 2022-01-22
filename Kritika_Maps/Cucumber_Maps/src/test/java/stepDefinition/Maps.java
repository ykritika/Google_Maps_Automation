package stepDefinition;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

//import CucumberMaps.Cucumber_Maps.Maps;
import CucumberMaps.Cucumber_Maps.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GoogleMapsPage;

//@RunWith(Cucumber.class)
public class Maps extends base{
	public static WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());

	
	@Given("^initialize the browser$")
	public void initialize_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver =initializeDriver();
		 log.info("Driver is initialized");
	}
	
	@And("^navigate to google maps$")
	public void navigate_to_google_maps() throws IOException, InterruptedException
	{
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/maps");
		 log.info("Navigated to google maps");
		
	}
	
	@When("^search city in searchbox$")
	public void search_city_in_searchbox() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 GoogleMapsPage googleMapsActions=new GoogleMapsPage(driver);	
		googleMapsActions.searchbox().click();	
		googleMapsActions.searchbox().sendKeys("San Francisco, California");
		googleMapsActions.searchbox().sendKeys(Keys.ARROW_DOWN);
		googleMapsActions.searchbox().sendKeys(Keys.ENTER);
		 log.info("San Francisco city is searched");
		 Thread.sleep(3000);
		 String url=driver.getCurrentUrl();
			String coordinates[]=url.split("@")[1].split(",");
			if(coordinates[0].equals("37.7576793") && coordinates[1].equals("-122.5076402")) {
				
			log.info("Coordinates are equal");
				
			}
			else
			{
				log.info("Coordinates are not equal");	
			}
			 log.info("coordinates verified");
	}
	 
	
	@Then("^prints routes information$")
	public void prints_routes_information() throws IOException, InterruptedException {
  GoogleMapsPage googleMapsActions=new GoogleMapsPage(driver);	
  FileWriter fw=new FileWriter("routes.txt");
		
		googleMapsActions.getDirections().click();
		googleMapsActions.getDirectionsByCar().click();
		googleMapsActions.chooseStartingPoint().click();
		googleMapsActions.chooseStartingPoint().sendKeys("Chico,California");
		 Thread.sleep(3000);
		googleMapsActions.chooseStartingPoint().sendKeys(Keys.ARROW_DOWN);
		googleMapsActions.chooseStartingPoint().sendKeys(Keys.ENTER);
		if(googleMapsActions.getRoutesList().size()>=2)
		{
			for(int i=0;i<googleMapsActions.getRoutesList().size();i++)
			{
				
				String routeTime=googleMapsActions.getRouteTime(i).getText();
				String routeMiles=googleMapsActions.getRouteMiles(i).getText();
				String routeName=googleMapsActions.getRouteName(i).getText();
				fw.write("Route Time:"+routeTime+"\n");
				fw.write("Route Miles:"+routeMiles+"\n");
				fw.write("Route Name:"+routeName+"\n");  
			}
		}
		else
		{
			log.info("Routes are less than 2");
		}

        fw.close(); 
	}
	
	@And("^close the browser$")
	public void close_the_browser() 
	{
		driver.close();	
	}
	
}






