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

public class InsertOnCalls {
	boolean test = false;

  @Test
  public void insertoncall() throws FileNotFoundException {
	
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
		//Choose organisation TEST
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
	//Go to On Call
	try{
		Thread.sleep(1500);
	driver.findElement(By.linkText("On Call")).click();
	}catch(Exception e)
	{
		System.out.println(e);
		}
	int i;
	for(i=0;i<5;i++)
		{
	//Click on '+'
	try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-plus-sign")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Modal window is displayed
	driver.findElement(By.className("modal-content")).isDisplayed();
	try{
		Thread.sleep(1500);
		WebElement devicedrop = driver.findElement(By.name("user"));
		Select device = new Select(devicedrop);
		device.selectByVisibleText("test.admin");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	try{
	Thread.sleep(1500);
   	//Telephone & email are filled automatically
	driver.findElement(By.name("user.phoneNumber")).isDisplayed();
	driver.findElement(By.name("user.emailPrimary")).isDisplayed();
	//Set start of shift & end of shift
	driver.findElement(By.name("startTime")).sendKeys("00:00");
	}catch(Exception e)
	{
		System.out.println(e);
	}
	try{
		Thread.sleep(1500);
	driver.findElement(By.xpath("//button[@type='button'])[5]"));
	}catch(Exception e)
	{
		System.out.println(e);
	}
	driver.findElement(By.name("endTime")).sendKeys("00:00");

	//Press Done
	try{
		Thread.sleep(1500);
	driver.findElement(By.xpath("//button[@type='button'])[5]"));
	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	WebElement orgdrop = driver.findElement(By.cssSelector("div.input-group > select[name='organisation']"));
	Select org = new Select(orgdrop);
	org.selectByVisibleText("TEST");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Press Save
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("save_device")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	i++;

    if(!driver.getPageSource().contains("Success! The register was saved/update successfully"))
    {
    	test = true;
    	System.out.println ("Error message is displayed to correct start shit & end shift & on call is not created");
      }
    else
    {
    	System.out.println ("Error message is not displayed to correct start shit & end shift & on call is created");
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
	test=true;
        }
    }

