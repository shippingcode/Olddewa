package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.DashboardPageFactory;
import PageFactory.LoginPageFactory;
import PageFactory.LogoutPageFactory;
import PageFactory.SystemUserPageFactory;

public class CreateSystemUserTest {

	private static final String USERNAME = null;

	private static final WebElement ORGANISATION = null;

	WebDriver driver;

	LoginPageFactory objLogin;

	DashboardPageFactory objDashboard;

	SystemUserPageFactory objSystemUser;

	LogoutPageFactory objLogout;

	@BeforeTest

	public void setup() {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://35.187.12.26");
		driver.manage().window().maximize();

	}

	/**
	 * 
	 * This test go to http://dewa.hubeleon.ae/
	 * 
	 * Verify login page title as DEWA
	 * 
	 * Login to application
	 * 
	 * Create device
	 * 
	 */

	@Test(priority = 0)

	public void CreateDevice() {

		// Create Login Page object

		objLogin = new LoginPageFactory(driver);

		// login to application

		objLogin.loginToDEWA("eConnect.support", "Pa55w0rd1");

		objDashboard = new DashboardPageFactory(driver);

		// Verify Dashboard

		Assert.assertTrue(objDashboard.getDashboard().contains("DASHBOARD"));

		objSystemUser = new SystemUserPageFactory(driver);
		objSystemUser.MenuSystemUser();
		objSystemUser.CreateSystemUser(USERNAME);
		objSystemUser.SearchUser(USERNAME);
		objSystemUser.ResetPassword();

		// Logout
		objLogout = new LogoutPageFactory(driver);
		objLogout.logoutFromDEWA();

	}

}