package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.DashboardPageFactory;
import PageFactory.CreateDevicePageFactory;
import PageFactory.LoginPageFactory;
import PageFactory.LogoutPageFactory;

public class CreateDeviceTest {

	private static final String DEVICENAME = null;
	private static final WebElement ORGANISATION = null;

	WebDriver driver;

	LoginPageFactory objLogin;

	CreateDevicePageFactory objDeviceList;

	LogoutPageFactory objLogout;
	DashboardPageFactory objDashboard;

	@BeforeTest

	public void setup() {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://dewa.hubeleon.ae");
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

		objDeviceList = new CreateDevicePageFactory(driver);

		// Call device creation
		objDeviceList.SelectOrganisation(ORGANISATION);
		objDeviceList.CreateDevice(DEVICENAME);

		// Logout
		objLogout = new LogoutPageFactory(driver);
		objLogout.logoutFromDEWA();

	}

}