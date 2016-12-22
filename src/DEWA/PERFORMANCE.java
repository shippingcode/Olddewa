package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class PERFORMANCE {
boolean test = false;

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
		//Go to PERFORMANCE Tab
		try{
			Thread.sleep(1500);
			driver.findElement(By.id("topmenu_issues")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		
		//Click on icon-chevron-down
		try{
			Thread.sleep(1500);
		driver.findElement(By.className("icon-chevron-down")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Press Next Button
		try{
			Thread.sleep(1500);
	    driver.findElement(By.name("next")).click();
		}catch(Exception e)
	    {
	    	System.out.println(e);
	    }
		    
		//Press Previous Button
	
	try{
		Thread.sleep(1500);
    driver.findElement(By.name("prev")).click();
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


