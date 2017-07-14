/*  Create Alert Content Profile */

package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AlertContentProfileNegativeTesting {
	boolean test = false;
	WebDriver driver = null;
	String AlertConetentProfile = GenerateData.generateRandomString(10);
	String subject = GenerateData.generateRandomString(10);
	String subject1 = GenerateData.generateRandomString(10);
	String sms = GenerateData.generateRandomNumber(10);
	String sms1 = GenerateData.generateRandomNumber(10);

	@Test
	public void createAlertContentProfile() throws FileNotFoundException {
		// Login
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Aila\\workspace\\dewa\\src\\DEWA\\datadriven.properties");
		try {
			prop.load(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Create Firefox drive
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url1"));
		try {
			Thread.sleep(1500);

			// Login into the software filling username & password
			driver.findElement(By.name("username")).sendKeys(prop.getProperty("username1"));
			driver.findElement(By.name("password")).sendKeys(prop.getProperty("password1"));
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
		/*
		 * try{ Thread.sleep(1500); WebElement orgdropdown =
		 * driver.findElement(By.name("organisation")); Select org = new
		 * Select(orgdropdown); org.selectByVisibleText("TEST");
		 * }catch(Exception e) { System.out.println(e); }
		 */
		// Go to OPERATIONS Tab
		driver.findElement(By.id("operations")).click();
		driver.findElement(By.linkText("Maintenance")).isDisplayed();
		driver.findElement(By.linkText("Alerts")).isDisplayed();

		// Go to Alerts
		try {
			Thread.sleep(1500);
			WebElement menu = driver.findElement(By.linkText("Alerts"));
			Actions actions = new Actions(driver);
			actions.moveToElement(menu).perform();
			driver.findElement(By.linkText("Alert Content Profile")).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Add alert content profile
		try {
			Thread.sleep(1500);
			driver.findElement(By.cssSelector("span.icon-plus ")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
		// Modal is displayed
		try {
			Thread.sleep(1500);
			driver.findElement(By.className("modal-content")).isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill name
		try {
			Thread.sleep(1500);
			driver.findElement(By.name("alertContentProfileName")).sendKeys(AlertConetentProfile);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Choose organisation
		try {
			Thread.sleep(1500);
			WebElement orgdrop = driver.findElement(By.cssSelector("div.col-md-6 > select[name='ownerOrganisation']"));
			Select org = new Select(orgdrop);
			org.selectByVisibleText("TEST");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill names
		try {
			Thread.sleep(1500);
			driver.findElement(By.name("emailAlertSubjectText")).sendKeys(subject);

		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			driver.findElement(By.name("emailClearanceSubjectText")).sendKeys(subject1);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Thread.sleep(1500);
			driver.findElement(By.name("smsAlertText")).sendKeys(sms);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			driver.findElement(By.name("smsClearanceText")).sendKeys(sms1);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Thread.sleep(1500);
			driver.findElement(By.id("save_device")).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		if (driver.findElement(By.className("modal-dialog")).isDisplayed()) {
			test = true;
			System.out.println("Alert Content Profile is not created");
		} else {
			System.out.println("Something went wrong");
		}
		try {
			Thread.sleep(1500);
			driver.findElement(By.name("close_alertContentProfile")).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Logout
		try {
			Thread.sleep(1500);
			driver.findElement(By.cssSelector("a.widget-icon > span.icon-eject")).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		test = true;

	}
}

