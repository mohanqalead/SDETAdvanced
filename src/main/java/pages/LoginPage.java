package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.Base;
import Common.CommonDriverMethods;

public class LoginPage {
	WebDriver driver;
	CommonDriverMethods driverMethods;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driverMethods = new CommonDriverMethods(this.driver);
	}
	
	@FindBy(id="user-name")
	private WebElement userNameTextbox;
	
	@FindBy(id="password")
	private WebElement passwordTextBox;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuButton;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutLink;
	
	public void login(String userName, String password) throws Exception {
		try {
			driverMethods.waitForWebElementToAppear(userNameTextbox);
			userNameTextbox.sendKeys(userName);
			passwordTextBox.sendKeys(password);
			loginButton.click();
//			driverMethods.waitForAlertToPresent();
//			Alert alert = driver.switchTo().alert();
//			alert.accept();
			
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	public boolean isUserLoggedIn()throws Exception
	{
		boolean userlogged = false;
		try {
			driverMethods.waitForWebElementToAppear(menuButton);
			if(menuButton.isDisplayed()) {
				menuButton.click();
				driverMethods.waitForWebElementToAppear(logoutLink);
				userlogged = logoutLink.isDisplayed();
			}
		
		}catch(Exception e) {
			throw new Exception(e);
		}
		return userlogged;
		}

}
