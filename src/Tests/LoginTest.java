package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;

public class LoginTest {

	WebDriver driver;

	LoginPage objLogin;

	DashboardPage objDashboard;

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

	public void test_Dashboard() {

		// Create Login Page object

		objLogin = new LoginPage(driver);

		// login to application

		objLogin.loginToDEWA("test.admin", "Pa55w0rd1");

		// go the next page

		objDashboard = new DashboardPage(driver);

		// Verify Dashboard

		Assert.assertTrue(objDashboard.getDashboard().contains("DASHBOARD"));

	}
}