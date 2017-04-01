/* Create Owner */

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

public class CreateOwner {
	boolean test = false;
	GenerateData genData = null;
	String owner = GenerateData.generateRandomString(20);
  @Test
         public void createowner() throws FileNotFoundException {
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
	  			}

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
	  		if(driver.getPageSource().contains("Success! The register was saved/update successfully"))
			{
				test=true;
				System.out.println("Owner was created with success");
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
	 
	  	}
	
  }

