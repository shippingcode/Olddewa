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

public class OPERATIONSAlertsSLAProfile {
	WebDriver driver = null;
	boolean test = false;
  @Test
  public void f() throws FileNotFoundException {
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
     // WebDriver driver = new FirefoxDriver();
      driver.manage().window().maximize();
	  //Access http://66.hubeleon.appspot.com
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
	//Go to OPERATIONS Tab
	driver.findElement(By.id("topmenu_maintenance")).click();
	driver.findElement(By.linkText("Maintenance")).isDisplayed();
	driver.findElement(By.linkText("Alerts")).isDisplayed();

	//Go to Alerts
	try{
	Thread.sleep(1500);
	WebElement menu = driver.findElement(By.linkText("Alerts"));
	Actions actions = new Actions(driver);
	actions.moveToElement(menu).perform();
	driver.findElement(By.linkText("SLA Profile")).click();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	//Check if lables are displayed
	if(driver.getPageSource().contains("SLA Profile")
	&&
	driver.getPageSource().contains("Name")
	&&
	driver.getPageSource().contains("Mon")
	&&
	driver.getPageSource().contains("Tue")
	&&
	driver.getPageSource().contains("Wed")
	&&
	driver.getPageSource().contains("Thu")
	&&
	driver.getPageSource().contains("Fri")
	&&
	driver.getPageSource().contains("Sat")
	&&
	driver.getPageSource().contains("Sun")
	&&
	driver.getPageSource().contains("Starts")
	&&
	driver.getPageSource().contains("Ends")
	&&
	driver.getPageSource().contains("Acknowledge")
	&&
	driver.getPageSource().contains("Attendance")
	&&
	driver.getPageSource().contains("Resolution")
	&&
	driver.getPageSource().contains("Overdue hour Penalty")
	&&
	driver.getPageSource().contains("Contract")
	&&
	driver.getPageSource().contains("Organisation")
	&&
	driver.getPageSource().contains("Actions"))
	{
		test = true;
		System.out.println("Lables are displayed on the page");
	}
	else
	{
		System.out.println("Lables are not displayed on the page");
	}
	//Click on add
	try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-plus-sign")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill a name
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("slaName")).sendKeys("name");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Check Monday
	if (!driver.findElement(By.name("coverMonday")).isSelected())
	{
	     driver.findElement(By.name("coverMonday")).click();
	}
	//Select Cover Start hour
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("coverStartTime")).sendKeys("05:00");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Press Done
	try{
	Thread.sleep(1500);
	driver.findElement(By.xpath("//button[@type='button'])[3]")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	driver.findElement(By.name("coverEndTime")).sendKeys("10:00");

	//Press Done
	try{
	Thread.sleep(1500);
	driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Acknowledge
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("acknowledgeMins")).clear();
	driver.findElement(By.name("acknowledgeMins")).sendKeys("12");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Attendance
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("attendanceMins")).clear();
	driver.findElement(By.name("attendanceMins")).sendKeys("12");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Resolution
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("resolutionMins")).clear();
	driver.findElement(By.name("resolutionMins")).sendKeys("200");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Overdue Hour Penalty
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("overdueHourPenalty")).clear();
	driver.findElement(By.name("overdueHourPenalty")).sendKeys("10");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Choose organization
	//driver.findElement(By.name("organisation")).click();
	try{
	Thread.sleep(1500);
	WebElement orgdrop = driver.findElement(By.cssSelector("div.input-group > select[name='organisation']"));
	Select org = new Select(orgdrop);
	org.selectByVisibleText("TEST");
	}catch(Exception e)
	{
	System.out.println(e);
	}

	//Press Save Button
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("save_device")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Logout
		try{
			Thread.sleep(1500);
		driver.findElement(By.className("icon-eject")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		test=true;

  }
  }

