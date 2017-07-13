/* Create Work Order */

package DEWA;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateWorkOrder {
	boolean test = false;
	

  @Test
  public void createWorkOrder() throws FileNotFoundException {
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
	driver.findElement(By.linkText("Work Orders")).click();
	}catch(Exception e)
	{
		System.out.println(e);
		}
	
	//Click on Actions
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("actionsMenu")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Raise new work order
	try{
	Thread.sleep(1500);
	driver.findElement(By.linkText("Create issue")).click();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
/*//Choose device
	String textToSelect = "NewDevice";
	WebElement autoOptions= driver.findElement(By.name("deviceSelectContainer:deviceSelect"));
	autoOptions.sendKeys("d");

	java.util.List<WebElement> optionsToSelect = driver.findElements(By.name("deviceSelectContainer:deviceSelect"));
	
	for(WebElement option : optionsToSelect){
	  	    if(option.getText().equals(textToSelect)) {
	        option.click();
	        break;
	  	    }
	  	    
     	}
*/
	driver.findElement(By.name("deviceSelectContainer:deviceSelect")).sendKeys(Keys.ARROW_DOWN);
	 try{
			Thread.sleep(1500);
			WebElement devicedrop = driver.findElement(By.name("deviceSelectContainer:deviceSelect"));
		    Select device = new Select(devicedrop);
		    device.selectByIndex(2);
          }catch(Exception e)
	        {
	      	System.out.println(e);
	        } 
	
	   driver.findElement(By.name("deviceSelectContainer:deviceSelect")).sendKeys(Keys.ENTER);


	//Fill an work order title
	   try{
		Thread.sleep(1500);
		driver.findElement(By.name("workOrderTitle")).sendKeys("Selenium WorkOrder");
	   }catch(Exception e)
		{
			System.out.println(e);
		}

		
	     //Choose type of work
	        try{
			Thread.sleep(1500);
			WebElement worktype = driver.findElement(By.name("prioritySelectContainer:eventPriority"));
		    Select type = new Select(worktype);
		    type.selectByVisibleText("Low");
             }catch(Exception e)
	        {
	      	System.out.println(e);
	        } 
		

		    //Choose organisation
	        try{
			Thread.sleep(1500);
		    WebElement orgdrop = driver.findElement(By.name("user"));
		    Select org = new Select(orgdrop);
		    org.selectByIndex(1);
             }catch(Exception e)
            {
             System.out.println(e);
             }
	        
	        //Press Save
	        try{
	        Thread.sleep(1500);
	        driver.findElement(By.name("save")).click();
	        }catch(Exception e)
            {
	        System.out.println(e);
             }
	

    if(driver.getPageSource().contains("Success! The register was saved/update successfully"))
    {
    	test = true;
    	System.out.println ("Work order is created with success");
    	
      }
    else
    {
    	System.out.println ("Something went wrong");
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






