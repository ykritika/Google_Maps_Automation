package CucumberMaps.Cucumber_Maps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class base  {
  public WebDriver driver;
  
	public WebDriver initializeDriver() throws IOException
	{
		 Properties prop=new Properties();
		 String path = System.getProperty("user.dir");
		 FileInputStream fis=new FileInputStream(path+"\\src\\main\\java\\CucumberMaps\\Cucumber_Maps\\data.properties");
		 prop.load(fis);
	 	String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",path+"\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			//firefox driver initialization code
		}
		else if(browserName.equals("IE"))
		{
			//IE driver initialization cod
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
