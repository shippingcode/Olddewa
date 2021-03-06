/*Bar On Call   */


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

public class BarOnCallOPERATIONS {
	boolean test = false;

  @Test
  public void barrOnCall() throws FileNotFoundException {
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
	
   	//Telephone & email are filled automatically
	/* deprecated 
	//driver.findElement(By.name("user.phoneNumber")).isDisplayed();
	//driver.findElement(By.name("user.emailPrimary")).isDisplayed();
	//Set start of shift & end of shift
	
	//try{
	Thread.sleep(1500);
	WebElement orgdrop = driver.findElement(By.cssSelector("div.input-group > select[name='organisation']"));
	Select org = new Select(orgdrop);
	org.selectByVisibleText("TEST");
	}catch(Exception e)
	{
	System.out.println(e);
	}*/
	try{
		Thread.sleep(1500);
		WebElement userdrop = driver.findElement(By.id("equipmentType"));
		Select user = new Select(userdrop);
		user.selectByVisibleText("test.admin");
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
	
	//Find On Call
	 WebElement table = driver.findElement(By.cssSelector("div.col-md-12 > div.col-md-4"));

	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows) {
	java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	for (WebElement cell : cells) {
		while(cell.getText()== "DEWA Admin (test.admin)")
		{
try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("icon-ban-circle")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	     }
		}
	}
	}
		//Verify if becomes INACTIVE
	//Find alert Content Profile
		 WebElement table1 = driver.findElement(By.cssSelector("div.col-md-12 > div.col-md-4"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row1 : allRows1) {
		java.util.List<WebElement> cells1 = row1.findElements(By.tagName("td"));
		for (WebElement cell : cells1) {
		while(cell.getText()== "DEWA Admin (test.admin)"){

	try{
		Thread.sleep(1500);
		 if(driver.getPageSource().contains("INACTIVE"))
		    {
		    	test = true;
		    	System.out.println ("On Call becomes inactived with success");
		    	
		      }
		    else
		    {
		    	System.out.println ("Something went wrong");
		       }
		}catch(Exception e)
		{
		System.out.println(e);
		     }
		   }
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
	}
  }





