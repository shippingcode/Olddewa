
/* Check if message has been sent for device UAE-HBN-CCL12, date = Mar 29, 2017 11:33:42 AM */
package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DeviceHistoryMessages {
	boolean test = false;
	GenerateData genData = null;
	String device = GenerateData.generateRandomString(10);
	String issue = GenerateData.generateRandomString(10);
	
  @Test
  public void DeviceMessage() throws FileNotFoundException {
	  //1. Login
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
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username2"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password2"));
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	  	  //2. DEVICES LIST 
	//Go to List
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("devices")).click();
		driver.findElement(By.linkText("List")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Go to 1st device Available
		driver.findElement(By.xpath("//table[@id='table']/tbody/tr/td[10]/a/span")).click();
		 try {
		 Thread.sleep(1500);
		 driver.findElement(By.linkText("History")).click();
		// driver.findElement(By.xpath("//a[contains(text(),'Messages')])[1]")).click();
		 driver.findElement(By.linkText("Messages")).click();
		 }
		  catch (Exception e) {
		  System.out.println(e);
		  }	
		 
		 //Open the message
		//Check the device's status
			//Find organisation already created in the table of organisations
			 WebElement table = driver.findElement(By.className("content"));
			// Now get all the TR elements from the table
			java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
			// And iterate over them, getting the cells
			for (WebElement row : allRows) {
			java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) 
			if(cell.getText()== "Mar 29, 2017 11:33:42 AM");
        	{
        	}
        	
			}
        	try {
   	         Thread.sleep(1500);
        	driver.findElement(By.cssSelector("span.icon-envelope")).click();
        	  }
	        catch (Exception e) {
	            System.out.println(e);
	        }
      
          	if(driver.findElement(By.id("contendScroll")).isDisplayed() && driver.findElement(By.name("panelEventDetail:deviceLink")).isDisplayed());
          	{
          		System.out.println("Message is displayed");
          		test = true;
            	}

			 //Logout
	        try {
	         Thread.sleep(1500);
	         driver.findElement(By.className("icon-eject")).click();
	        }
	        catch (Exception e) {
	            System.out.println(e);
	        }
     }
  }
