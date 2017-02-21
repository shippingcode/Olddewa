/* Create Alert Content Profile*/

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


public class CreateAlertContentProfile {
	boolean test = false;
	WebDriver driver = null;
	String AlertConetentProfile = GenerateData.generateRandomString(10);
	String subject = GenerateData.generateRandomString(10);
	String subject1 = GenerateData.generateRandomString(10);
	String emailbody = GenerateData.generateRandomString(10);
	String emailbody1 = GenerateData.generateRandomString(10);
	String phone = GenerateData.generateRandomNumber(10);
	String phone1 = GenerateData.generateRandomNumber(10);
	String sms = GenerateData.generateRandomNumber(10);
	String sms1 = GenerateData.generateRandomNumber(10);
	
	@Test
public void createAlertContentProfile() throws FileNotFoundException {
		//Login
	  Properties prop = new Properties();
	  FileInputStream file = new FileInputStream("C:\\Users\\Aila\\workspace\\dewa\\src\\DEWA\\datadriven.properties");
    try {
		prop.load(file);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

    //Create Firefox drive
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
	  driver.get(prop.getProperty("url1"));
	  try{
	  Thread.sleep(1500);

		//Login into the software filling username & password
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password1"));
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
	try{
	Thread.sleep(1500);
	WebElement orgdropdown = driver.findElement(By.name("organisation"));
	Select org = new Select(orgdropdown);
	org.selectByVisibleText("TEST");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Go to OPERATIONS Tab
	driver.findElement(By.id("operations")).click();
	driver.findElement(By.linkText("Maintenance")).isDisplayed();
	driver.findElement(By.linkText("Alerts")).isDisplayed();

	//Go to Alerts
	try{
	Thread.sleep(1500);
	WebElement menu = driver.findElement(By.linkText("Alerts"));
	Actions actions = new Actions(driver);
	actions.moveToElement(menu).perform();
	driver.findElement(By.linkText("Alert Content Profile")).click();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
	//Add alert content profile
	try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-plus")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Modal is displayed
	try{
	Thread.sleep(1500);
	driver.findElement(By.className("modal-body clearfix")).isDisplayed();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill name
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("alertContentProfileName")).sendKeys(AlertConetentProfile);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Choose organisation
	try{
	Thread.sleep(1500);
	WebElement orgdrop = driver.findElement(By.cssSelector("div.col-md-6 > select[name='ownerOrganisation']"));
	Select org = new Select(orgdrop);
	org.selectByVisibleText("TEST");
	}catch(Exception e)
	{
		System.out.println(e);
	}
	//Fill names
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("emailAlertSubjectText")).sendKeys(subject);

	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("emailClearanceSubjectText")).sendKeys(subject1);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill body text for alert & clearance
	try{
	Thread.sleep(1500);
	//driver.findElement(By.id("emailAlertBodyText")).clear();
	Actions actions1 = new Actions(driver);
	WebElement menu1 = null;
	actions1.moveToElement(menu1).perform();
	driver.findElement(By.id("emailAlertBodyText")).sendKeys(emailbody);
	}catch(Exception e)
	{
	System.out.println(e);
	}

	try{
	Thread.sleep(1500);
	//driver.findElement(By.id("emailClearanceSubjectBodyText")).clear();
	Actions actions2 = new Actions(driver);
	WebElement menu2 = null;
	actions2.moveToElement(menu2).perform();
	driver.findElement(By.id("emailClearanceSubjectBodyText")).sendKeys(emailbody1);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill phone numbers
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("phoneAlertText")).sendKeys(phone);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("phoneClearanceText")).sendKeys(phone1);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("smsAlertText")).sendKeys(sms);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("smsClearanceText")).sendKeys(sms1);
	}catch(Exception e)
	{
	System.out.println(e);
	}

	try{
	Thread.sleep(1500);
	driver.findElement(By.id("save_device")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	
	 if(driver.getPageSource().contains("Success! The register was saved/update successfully"))
	  {
		  test = true;
		  System.out.println("ALert Content Profile was saved with success");
	  }
	  else
	  {
		  System.out.println("Something went wrong");
	  }
	
	
	//Logout
	try{
	Thread.sleep(1500);
	driver.findElement(By.className("icon-eject")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	 }
	
	test = true;

        }
}
