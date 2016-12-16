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

public class InsertAlertsSLAProfile {

  WebDriver driver = null;
	boolean test = false;
	String[] profile = new String[]{"Profile1","Profile2","Profile3","Profile4","Profile5","Profile6","Profile7","Profile8",
 			"profile9","Profile10","Profile11","Profile12","Profile13","Profile14","Profile15","Profile16","Profile17",
 			"Profile18","Profile19","Profile20","Profile21"};
	String[] contract = new String[]{"contract1","contract2","contract3","contract4","contract5","contract6","contract7","contract8",
 			"contract9","contract10","contract11","contract12","contract13","contract14","contract15","contract16","contract17",
 			"contract18","contract19","contract20","contract21"};
@Test
public void f() throws FileNotFoundException {
	  Properties prop = new Properties();
	  FileInputStream file = new FileInputStream("D:\\workspace\\DEWA\\src\\DEWA\\datadriven.properties");
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
	  try{
	  Thread.sleep(1500);
	  WebElement orgdropdown = driver.findElement(By.name("organisation"));
	  Select org = new Select(orgdropdown);
	  org.selectByVisibleText("DEWA");
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
	driver.findElement(By.linkText("SLA Profile")).click();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	int i,j,k;
	for(i=0;i<21;i++)
		for(j=0;j<21;j++)
			for(k=0;k<21;k++)
		{
			{
				{
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
	driver.findElement(By.name("slaName")).sendKeys(profile[j]);
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
	driver.findElement(By.xpath("//button[@type='button'])[3]")).click();
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
	try{
	Thread.sleep(1500);
	WebElement orgdropdown = driver.findElement(By.cssSelector("div.input-group > select[name='organisation']"));
	Select org = new Select(orgdropdown);
	org.selectByVisibleText("DEWA");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill contract
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("contractName")).sendKeys(contract[k]);
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

             }
          }
       }
   
//Logout
try{
Thread.sleep(1500);
driver.findElement(By.className("icon-eject")).click();
}catch(Exception e)
{
System.out.println(e);
 }
}
}
