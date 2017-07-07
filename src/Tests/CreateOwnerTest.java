package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.DashboardPageFactory;
import PageFactory.CreateOwnerPageFactory;
import PageFactory.LoginPageFactory;
import PageFactory.LogoutPageFactory;

public class CreateOwnerTest {

	private static final String OWNER = null;

	private static final WebElement ORGANISATION = null;

	WebDriver driver;

	LoginPageFactory objLogin;

	CreateOwnerPageFactory objOwner;

	LogoutPageFactory objLogout;

	DashboardPageFactory objDashboard;

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

		objOwner = new CreateOwnerPageFactory(driver);

		// Call device creation
		objOwner.SelectOrganisation(ORGANISATION);
		objOwner.CreateOwner(OWNER);

		// Logout
		objLogout = new LogoutPageFactory(driver);
		objLogout.logoutFromDEWA();

	}

}