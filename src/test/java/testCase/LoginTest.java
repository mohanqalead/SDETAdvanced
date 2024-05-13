package testCase;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Common.Base;
import Utils.DataReader;
import pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginPage;

	/**
	 * Test to verify page title
	 */
	@Test(priority = 1)
	public void verifyPageTitle() {
		try {
			loginPage = new LoginPage(driver);
			Assert.assertEquals("Swag Labs", driver.getTitle());
			// loginPage.login();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test - Login to Application
	 * 
	 * @throws Exception
	 */
	@Test(dataProvider = "LoginData", priority = 2, testName = "LoginTest")
	public void loginToApp(Map data) throws Exception {

		loginPage.login(data.get("username").toString(), data.get("password").toString());
		Assert.assertTrue(loginPage.isUserLoggedIn());
	}

	
	  @AfterMethod 
	  public void afterMethod(ITestResult result) throws IOException {
		 if(!result.isSuccess()) {
		
		 getScreenShot(result.getMethod().getMethodName());
		 } 
		}
	 

	@DataProvider(name = "LoginData")
	public Object[][] loginData() throws IOException {
		return DataReader.readData("//src//test//java//testresources//TestData//Login.xlsx", "Login");
	}

}
