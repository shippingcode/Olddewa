/* Edit and save owner by changing Change OCHP operator ID into 890 */

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

public class EditAndSaveOwner {
  boolean test = false;
	GenerateData genData = null;
	String owner = GenerateData.generateRandomString(20);
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
       public void editandsaveOwner() throws FileNotFoundException {
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
	  		//Change org into TEST
	  		try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.name("organisation"));
				Select org = new Select(orgdropdown);
				org.selectByVisibleText("TEST");
				}catch(Exception e)
				{
					System.out.println(e);
				}
  		//Add owner

	  		//Go on Organization
	  		try{
	  		Thread.sleep(1500);
	  		driver.findElement(By.cssSelector("span.icon-link")).click();


	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  			}

	  			//Click on Add new owner
	  			try{
	  			Thread.sleep(1500);
	  			driver.findElement(By.linkText("Add")).click();
	  			}catch(Exception e)
	  		    {
	  			System.out.println(e);
	  			}

	  	   //Modal window is displayed & add new owner
	  		try{
	  		Thread.sleep(1500);
	  		//Check for modal window is displayed
	  			driver.findElement(By.className("modal-dialog")).isDisplayed();
	  			}catch(Exception e)
	  			{
	  			 System.out.println(e);
	  			}
	  	    //Fill an owner name
	  			try{
	  			Thread.sleep(1500);
	  			driver.findElement(By.name("organisationName")).sendKeys(owner);
	  			}catch(Exception e)
	  			{
	  				System.out.println(e);
	  			}
	  			/* deprecated
	  			//Choose alarm
	  			try{
	  			Thread.sleep(1500);
	  			WebElement alarmdropdown = driver.findElement(By.name("alertContentProfile"));
	  			Select alarm = new Select(alarmdropdown);
	  			 alarm.selectByVisibleText("alert1");
	  			}catch(Exception e)
	  			{
	  				System.out.println(e);
	  			}
	  			//Choose license
	  			try{
	  			Thread.sleep(1500);
	  			WebElement licensedrop = driver.findElement(By.name("license"));
	  			Select license = new Select(licensedrop);
	  			license.selectByVisibleText("Default");
	  			}catch(Exception e)
	  			{
	  				System.out.println(e);
	  			}*/

	  		//Choose time zone
	  		try{
	  		Thread.sleep(1500);
	  		WebElement timezonedropdown = driver.findElement(By.name("timezone"));
	  	    Select timezone = new Select(timezonedropdown);
	  	    timezone.selectByVisibleText("Europe/Bucharest");
	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  		}
	  	//Choose language
	  		try{
		  	Thread.sleep(1500);
		  	WebElement langdropdown = driver.findElement(By.name("languageDCC"));
		  	Select lang = new Select(langdropdown);
		  	lang.selectByVisibleText("ENGLISH");
	  		}catch(Exception e)
		  	{
		  	System.out.println(e);
		  	}
	  		
	  		//Choose locale
	  		try{
			Thread.sleep(1500);
			WebElement localedropdown = driver.findElement(By.name("localeDDC"));
			Select locale = new Select(localedropdown);
			locale.selectByVisibleText("UNITED KINGDOM");
		  	}catch(Exception e)
			{
			System.out.println(e);
			}

	  		//Check radio button ochpEnabled
	  		try{
	  		Thread.sleep(1500);
	  		driver.findElement(By.xpath("//input[@name='ochpEnabled']")).click();
	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  		}
	  		//Add Operator Id
	  		try{
	  			Thread.sleep(1500);
	  		driver.findElement(By.name("ochpOperatorId")).sendKeys("99");
	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  		}
	  	  //Press Save Button
	  		try{
	  		Thread.sleep(1500);
	  		driver.findElement(By.name("save_owner")).click();
	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  		}
	  		
	  		//Change from top drop down new organisation
	  	
	  		try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.name("organisation"));
				Select org = new Select(orgdropdown);
				org.selectByVisibleText(owner);
				}catch(Exception e)
				{
					System.out.println(e);
				}
	  		//Create Alert Content Profile
	  		//Go to OPERATIONS Tab
	  		try{
			Thread.sleep(1500);
	  		driver.findElement(By.id("operations")).click();
	  		}catch(Exception e)
			{
				System.out.println(e);
			}
	  		/*
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
	  		driver.findElement(By.cssSelector("div.side.pull-right > a.widget-icon")).click();
	  		}catch(Exception e)
	  		{
	  		System.out.println(e);
	  		}
	  		//Modal is displayed
	  		try{
	  		Thread.sleep(1500);
	  		driver.findElement(By.className("modal-content")).isDisplayed();
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
	  		*/
	  	//Go on Organization
	  		try{
	  		Thread.sleep(1500);
	  		driver.findElement(By.cssSelector("span.icon-link")).click();
	  		}catch(Exception e)
	  		{
	  		System.out.println(e);
	  		}
     //Edit the owner
	     try{
			Thread.sleep(1500);
			driver.findElement(By.cssSelector("span.icon-pencil")).click();
			driver.findElement(By.name("ochpOperatorId")).sendKeys("890");
			}catch(Exception e)
			{
			System.out.println(e);
			     }
		 		
	  
			//Save the owner
			
			//Press Save Button
	  		try{
	  		Thread.sleep(1500);
	  		driver.findElement(By.name("save_owner")).click();
	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  		}
	  	//Change org into TEST
	  		try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.name("organisation"));
				Select org = new Select(orgdropdown);
				org.selectByVisibleText("TEST");
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
			test = true;
	  		
  }
}
