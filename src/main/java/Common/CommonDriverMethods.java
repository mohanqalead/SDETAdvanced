package Common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDriverMethods {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CommonDriverMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForWebElementToAppear(WebElement element) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitForAlertToPresent() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}


}
