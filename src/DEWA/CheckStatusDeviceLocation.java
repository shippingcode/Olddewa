/* Check device status in location */
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

public class CheckStatusDeviceLocation {
	boolean test=false;
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
			//WebDriver driver = new ChromeDriver();
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

			//Choose organisation eCars Scheme
			try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.name("organisation"));
				Select org = new Select(orgdropdown);
				 org.selectByVisibleText("TEST");
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			//Go to Location
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("devices")).click();
			driver.findElement(By.linkText("Location")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			 try {
		            Thread.sleep(1500);
		            driver.findElement(By.id((String)"search")).sendKeys("Strada Dionisie Lupu");
		        }
		        catch (Exception e) {
		            System.out.println(e);
		        }
		        try {
		            Thread.sleep(1500);
		            driver.findElement(By.id((String)"btnSearch")).click();
		        }
		        catch (Exception e) {
		            System.out.println(e);
		        }
		        try {
		            Thread.sleep(1500);
		            driver.findElement(By.cssSelector((String)"span.icon-search")).click();
		        }
		        catch (Exception e) {
		            System.out.println(e);
		        }
			 //Modal window is displayed & add new device
		
			if(driver.getPageSource().contains("Offline"))
			{			{
		   //Click on button & make sure that status is offline
			try{
			Thread.sleep(1500);
			driver.findElement(By.linkText("Offline")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			 }
			if (driver.getPageSource().contains("Offline"))
			{
			System.out.println("Device's status is Offline");
			}
			else System.out.println("Device's status is not correct");
			}
			 
			} else if(driver.getPageSource().contains("Unavailable"))
			{
			//Click on button & make sure that status is offline
			try{
			Thread.sleep(1500);
			driver.findElement(By.linkText("Unavailable")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}	
			if (driver.getPageSource().contains("Unavailable"))
			{
			System.out.println("Device's status is Unavailable");
			}
			else System.out.println("Device's status is not correct");
			
	        } else if (driver.getPageSource().contains("Unknown"))
	         {
	        //Click on button & make sure that status is offline
	        try{
	       Thread.sleep(1500);
	       driver.findElement(By.linkText("Unknown")).click();
	      }catch(Exception e)
	      {
	      System.out.println(e);
	       }	
	      if (driver.getPageSource().contains("Unknown"))
	     {
	     System.out.println("Device's status is Unknown");
	     }
    	  else System.out.println("Device's status is not correct");
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

	
		










