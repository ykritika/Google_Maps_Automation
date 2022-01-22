package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMapsPage {
	public WebDriver driver;
	public GoogleMapsPage(WebDriver driver)
	{
		this.driver=driver;
	}	
	
	
	By searchbox= By.id("searchboxinput");
	
	public WebElement searchbox()
	{
	return driver.findElement(searchbox);
	}
	
    By directions= By.xpath("//div[text()='Directions']");
	
	public WebElement getDirections()
	{
	return driver.findElement(directions);
	}
	
	 By car= By.xpath("//img[@data-tooltip='Driving']");
		
	public WebElement getDirectionsByCar()
	{
	return driver.findElement(car);
	}
	
	By startingpoint= By.xpath("//input[contains(@placeholder,'Choose starting point,')]");
			
	public WebElement chooseStartingPoint()
	{
	return driver.findElement(startingpoint);
	}
			
	 By routes= By.xpath("//div[contains(@id,'section-directions-trip')]");
				
	 public List<WebElement> getRoutesList()
	{
	return driver.findElements(routes);
	}
				
				 
	public WebElement getRouteTime(int i)
	{
	return driver.findElement(By.xpath("//div[@id='section-directions-trip-"+i+"']/div/div/div/div[1]/span[1]"));
	}
	public WebElement getRouteMiles(int i)
	{
	return driver.findElement(By.xpath("//div[@id='section-directions-trip-"+i+"']/div/div/div/div[1]/following-sibling::div/div"));
	}
	public WebElement getRouteName(int i)
	{
	return driver.findElement(By.xpath("//div[@id='section-directions-trip-"+i+"']/div/div/div[2]/h1/span"));
	}
		
}
