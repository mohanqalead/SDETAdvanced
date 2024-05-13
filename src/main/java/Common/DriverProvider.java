package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverProvider {
	public WebDriver driver;

	
	public WebDriver initDriver() throws IOException
	{
		 Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+"//src//main//java//Assessment//resources//GlobalData.Properties");
			prop.load(fis);
			String browser = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
			
			if(browser.equalsIgnoreCase("chrome"))
			{

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			}else if(browser.equalsIgnoreCase("firefox"))
			{

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			return driver;

			
	}

}
