package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class USE {
boolean test = false;

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
		//Go to PERFORMANCE Tab
		try{
			Thread.sleep(1500);
			driver.findElement(By.id("topmenu_use")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		
		//Create filter
		try{
			Thread.sleep(1500);
		driver.findElement(By.name("search2")).sendKeys("SeleniumDevice");
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Set start date
		try{
			Thread.sleep(1500);
		driver.findElement(By.name("start")).sendKeys("01/01/2016");
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Set end date
		try{
			Thread.sleep(1500);
		driver.findElement(By.name("end")).sendKeys("12/12/2016");
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Press Filter
		try{
		Thread.sleep(1500);
       driver.findElement(By.id("searchUsage")).click();
	   }catch(Exception e)
      {
    	System.out.println(e);
       }
		//Press Clear filters
		try{
		Thread.sleep(1500);
	    driver.findElement(By.id("clear_search")).click();
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


