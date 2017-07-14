package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.LogoutPageFactory;
import Pages.LoginPage;

public class LogoutTest {

	WebDriver driver;

	LogoutPageFactory objLogout;

	LoginPage objLogin;

	@BeforeTest

	public void setup() {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://dewa.hubeleon.ae");

	}

	/**
	 * 
	 * This test case will login in http://dewa.hubeleon.ae/
	 * 
	 * Login to application
	 * 
	 * Verify the home page using Dashboard message
	 * 
	 */

	@Test(priority = 0)

	public void test_logout_with_success() {

		objLogin = new LoginPage(driver);

		// login to application

		objLogin.loginToDEWA("test.admin", "Pa55w0rd1");

		// Create Logout Page object

		objLogout = new LogoutPageFactory(driver);

		// login to application

		objLogout.logoutFromDEWA();

		// go to Login page

		objLogin = new LoginPage(driver);

	}

}