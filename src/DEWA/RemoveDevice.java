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


public class RemoveDevice {
	boolean test = false;
	WebDriver driver = null;
	GenerateData genData = null;
	String device = GenerateData.generateRandomString(20);
    public void removedevice() throws FileNotFoundException {
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
				
		//Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("search")).sendKeys(device);
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Press Search Button
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("btnSearch")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Check the device's status
		//Find organisation already created in the table of organisations
		WebElement table = driver.findElement(By.id("table_wrapper"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
		java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
		for (WebElement cell : cells) {
		while(cell.getText()== device);
		{
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("Unavailable")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		 }
			   		  	  	 
		 }
		      }
			   	}
		//Remove device
    	
	 
	  //Click on 
	  try{
	  Thread.sleep(1500);
	  driver.findElement(By.cssSelector("span.icon-align-justify")).click();
	  }catch(Exception e)
	  {
	  System.out.println(e);
	  }
	  
	  //Click on Remove
	  try{
	  Thread.sleep(1500);
	  driver.findElement(By.linkText("Remove")).click();
	  }catch(Exception e)
	  {
	  System.out.println(e);
	  }
	  //Press Yes into the window
	  try{
	  Thread.sleep(1500);
	  driver.findElement(By.name("delete")).click();
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
			test=true;
			
	  } 
}

		

