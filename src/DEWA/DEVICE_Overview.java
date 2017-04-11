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

public class DEVICE_Overview {
	boolean test = false;
	GenerateData genData = null;
	String device = GenerateData.generateRandomString(10);
	String issue = GenerateData.generateRandomString(10);
	
  @Test
  public void DeviceOverview() throws FileNotFoundException {
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
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password1"));
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	  //Select organisation
	  try{
	  Thread.sleep(1500);
	  WebElement orgdropdown = driver.findElement(By.name("organisation"));
	  Select org = new Select(orgdropdown);
	  org.selectByVisibleText("TEST");
	  }catch(Exception e)
	  {
		System.out.println(e);
		}
	  //Go to Overview
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("devices")).click();
		driver.findElement(By.linkText("Overview")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("b.icon-filter")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		//Click on show only open events
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("Show only open events")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		//Check the device's status
		//Find organisation already created in the table of organisations
		 WebElement table = driver.findElement(By.name("events:formEvent:search"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
		java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
		for (WebElement cell : cells)
		if(cell.getText() =="Not closed")
		{
       	System.out.println("Only open events are being displayed");
		}
		else
		{
			System.out.println("Something is not right");
	         	}
		     }

	

		  //6. Logout
		
				try{
				Thread.sleep(1500);
				driver.findElement(By.className("icon-eject")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}

        }
  }
  


