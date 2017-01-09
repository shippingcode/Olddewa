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
	driver.findElement(By.id("topmenu_maintenance")).click();
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
	driver.findElement(By.name("device.site.siteName")).sendKeys("Ireland");
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
	driver.findElement(By.name("device.site.siteName")).clear();
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
	driver.findElement(By.name("device.site.siteName")).sendKeys("Ireland");
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
	driver.findElement(By.name("device.site.siteName")).clear();
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

	//Find organisation already created in the table of organisations
	 WebElement table = driver.findElement(By.id("DataTables_Table_0_wrapper"));

	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows) {
	    java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	    for (WebElement cell : cells) {
	    	    while(cell.getText()== "Owner1");{
	    try{
	   Thread.sleep(1500);
	    //When is found the org delete it
	    driver.findElement(By.cssSelector("span.icon-cogs")).click();
	    }catch(Exception e)
	   	{
	    System.out.println(e);
	             }
	         }
	    }
	   try{
	   Thread.sleep(1500);
	   WebElement orgdrop = driver.findElement(By.name("orgWorkOrder"));
	   Select org = new Select(orgdrop);
	   org.selectByVisibleText("TEST");
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
}
