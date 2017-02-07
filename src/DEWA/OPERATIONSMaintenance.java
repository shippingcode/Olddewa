package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OPERATIONSMaintenance {
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
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url1"));
		try{
			Thread.sleep(1500);

		//Login into the software filling username & password
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password1"));
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//Choose organisation DEWA
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
	driver.findElement(By.linkText("Work Orders")).isDisplayed();
	//Go to Work orders
	try{
	Thread.sleep(1500);
	driver.findElement(By.linkText("Maintenance")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Perform search
	try{
	Thread.sleep(1500);
	WebElement workdrop = driver.findElement(By.id("selectView"));
    Select work = new Select(workdrop);
	work.selectByVisibleText("All Upcoming");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Region
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("site.siteName")).sendKeys("Dubai");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Search Button
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("searchBtn")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Clear
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("site.siteName")).clear();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Perform Search
	try{
	Thread.sleep(1500);
	WebElement workdrop = driver.findElement(By.id("selectView"));
	Select work = new Select(workdrop);
	work.selectByVisibleText("All Due");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Region
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("site.siteName")).sendKeys("Dubai");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Search Button
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("searchBtn")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Clear
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("site.siteName")).clear();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Perform search
	try{
	Thread.sleep(1500);
	WebElement workdrop = driver.findElement(By.id("selectView"));
	Select work = new Select(workdrop);
	work.selectByVisibleText("All Maintenance Records");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Search Button
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("searchBtn")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}

	//Search by device deviceName
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("deviceName")).sendKeys("UAE-HBN-CCL10");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	
	//Click on assign
	 try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-cogs")).click();
	}catch(Exception e)
	{
	   System.out.println(e);
	  }
	 //Select organisation
	   try{
	   Thread.sleep(1500);
	   //WebElement orgdrop = driver.findElement(By.cssSelector("div.form-row > select[name='orgWorkOrder']"));
	   WebElement orgdrop = driver.findElement(By.cssSelector("div.form-row > select[name='orgWorkOrder']"));
	   Select org = new Select(orgdrop);
	   org.selectByVisibleText("DEWA");
	   }catch(Exception e)
	   	{
	   	System.out.println(e);
	   	}
	   //Select technician
	   try{
	   Thread.sleep(1500);
	   WebElement orgdrop = driver.findElement(By.cssSelector("div.form-row > select[name='user']"));
	   Select org = new Select(orgdrop);
		org.selectByVisibleText("DEWA");
		 }catch(Exception e)
		{
		 	System.out.println(e);
			}
	   //Save the changes
	   try{
	   Thread.sleep(1500);
	   driver.findElement(By.name("save"));
	   }catch(Exception e)
	   	{
	   	System.out.println(e);
	   	}
	   try{
	   Thread.sleep(1500);
	   driver.findElement(By.cssSelector("span.icon-globe"));
	   }catch(Exception e)
	   	{
	   	System.out.println(e);
	   	}
	   //Close the global
	   try{
		 Thread.sleep(1500);
		 driver.findElement(By.id("planMaintenance"));
		 }catch(Exception e)
		{
			System.out.println(e);
		   	}

         }
     }

