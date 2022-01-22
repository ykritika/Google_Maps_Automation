package runner;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import stepDefinition.Maps;


public class Listeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	

		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TakesScreenshot ts=(TakesScreenshot)Maps.driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationaFile=System.getProperty("user.dir")+"\\reports\\screenshot.png";
		try {
			FileUtils.copyFile(source, new File(destinationaFile));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
