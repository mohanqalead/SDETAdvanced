package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {
	protected WebDriver driver;
	DriverProvider driverProvider;
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()throws Exception
	{
		driverProvider = new DriverProvider();
		driver = driverProvider.initDriver();
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+"//src//main//java//Assessment//resources//GlobalData.Properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	@AfterSuite(alwaysRun = true)
	public void dearDown() {
		driver.quit();
	}
	
	public String getScreenShot(String testname) throws IOException 
	{
		//TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//"+ testname + ".png");
		FileUtils.copyFile(source, file);		
		return System.getProperty("user.dir") + "//reports//"+ testname + ".png";
	}

}
