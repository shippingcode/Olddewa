package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class InsertCorrectiveWorkOrders {
  boolean test = false;
  String[] corrective = {"Corrective1","Corrective2","Corrective3","Corrective4","Corrective5","Corrective6","Corrective7","Corrective8",
			"Corrective9","Corrective10","Corrective11","Corrective12","Corrective13","Corrective14","Corrective15","Corrective16","Corrective17",
			"Corrective18","Corrective19","Corrective20","Corrective21"};

	
@Test
public void insertcorrectiveworkorders() throws FileNotFoundException {
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
		driver.findElement(By.linkText("Work Orders")).isDisplayed();
		//Go to Work orders
		try{
			Thread.sleep(1500);
		driver.findElement(By.linkText("Work Orders")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		int i=0;
		int j= 0;
		while (i<5)
		while (j<5)
			{
				{
		//Raise new work order
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("actionsMenu")).click();
		driver.findElement(By.linkText("Raise new work order")).click();
		
		}catch(Exception e)
			{
		System.out.println(e);
		}
						
		//Fill an work order title
		driver.findElement(By.name("workOrder.workOrderTitle")).sendKeys(corrective[i]);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		//Choose type of work
		WebElement worktype = driver.findElement(By.name("workOrder.workOrderType"));
		Select type = new Select(worktype);
		type.selectByVisibleText("corrective");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			    
		 //Choose event priority
		WebElement eventtype = driver.findElement(By.cssSelector("div.col-md-6 > select[name='workOrder.eventPriority']"));
		Select event = new Select(eventtype);
		event.selectByVisibleText("High");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			    
		//Choose device
		try{
		Thread.sleep(1500);
		//driver.findElement(By.name("deviceSelect")).sendKeys(devices[j]);
		driver.findElement(By.cssSelector("div.col-md-9 > input[name='deviceSelect']")).sendKeys("device");
		WebElement devicedrop = driver.findElement(By.cssSelector("div.col-md-9 > select[name='deviceSelect']"));
		Select device = new Select(devicedrop);
		device.selectByVisibleText("device1");
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Choose organisation
		WebElement orgdrop = driver.findElement(By.id("organisationId"));
		Select org = new Select(orgdrop);
		org.selectByVisibleText("TEST");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			    
		//Press Save
		driver.findElement(By.id("saveWorkOrder")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
				}
			}	
		i++;
		j++;
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