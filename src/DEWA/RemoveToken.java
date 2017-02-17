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

public class RemoveToken {
String token = GenerateData.generateRandomAlphaNumeric(5);
	String info = GenerateData.generateRandomAlphaNumeric(5);
	boolean test = false;
	  @Test
	public void removetoken()  throws FileNotFoundException {
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
		//Add RFID CARD	

			//Go to RFID CARDS
				try{
					Thread.sleep(1500);
				driver.findElement(By.id("rfid")).click();
				driver.findElement(By.linkText("RFID Cards Overview")).click();
				}catch(Exception e)
				{
					System.out.println(e);
					}
				//Click on Add
				try{
				Thread.sleep(1500);
				driver.findElement(By.cssSelector("span.icon-plus")).click();
				}catch(Exception e)
				{
					System.out.println(e);
				}
		//Verify the modal is displayed
		driver.findElement(By.className("modal-content")).isDisplayed();
		//Choose type
		try{
		Thread.sleep(1500);
		WebElement carddropdown = driver.findElement(By.name("type"));
	    Select card = new Select(carddropdown);
	    card.selectByVisibleText("PHONE-NUM");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Fill token
		try{
		Thread.sleep(1500);
	    driver.findElement(By.name("token")).sendKeys(token);
		}catch(Exception e)
		{
		System.out.println(e);
		}
	    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	    //Fill token info
	    try{
		Thread.sleep(1500);
	    driver.findElement(By.name("info")).sendKeys(info);
	    }catch(Exception e)
		{
		System.out.println(e);
		}

	    //Choose organization
		WebElement orgdropdown = driver.findElement(By.name("creatorOrganisation"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select organisation = new Select(orgdropdown);
		organisation.selectByVisibleText("TEST");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Choose an user from dropdown list
		WebElement userdropdown = driver.findElement(By.name("user"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select user = new Select(userdropdown);
		user.selectByVisibleText("MotoristA");
		//Check the checkbox for OCHP Enabled
		try{
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='ochpEnabled']")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Choose OCHP Type
		WebElement ochpdropdown = driver.findElement(By.name("ochpType"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select ochp = new Select(ochpdropdown);
		ochp.selectByVisibleText("rfid");
    //Choose OCHP Subtype
		WebElement ochpsubtypedropdown = driver.findElement(By.name("ochpSubtype"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select ochpsubtype = new Select(ochpsubtypedropdown);
		ochpsubtype.selectByVisibleText("calypso");
		//Choose OCHP Representation
		WebElement ochprepresdropdown = driver.findElement(By.name("ochpTokenRepresentation"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select ochprepres = new Select(ochprepresdropdown);
		ochprepres.selectByVisibleText("sha-160");
		//Fill Contract ID
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("ochpContractId")).sendKeys("3464565");
		}catch(Exception e)
		{
		System.out.println(e);
		}

	    //Save all the info
	    try{
			Thread.sleep(1500);
		driver.findElement(By.id("save_eventrecord")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
	    //Verify is success message is displayed
	    try{
			Thread.sleep(1500);
	    driver.findElement(By.id("successAlert")).isDisplayed();
	    }catch(Exception e)
		{
			System.out.println(e);
			}
	    
	  //Search Token
	    
	    //Search the token already created
	    driver.findElement(By.id("search2")).sendKeys(token);
	    //Press Search button
	    try{
			Thread.sleep(1500);
	    driver.findElement(By.id("btnSearch")).click();
	    }catch(Exception e)
		{
			System.out.println(e);
			}
	   	//Remove RFID CARD
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("rfid")).click();
			driver.findElement(By.linkText("RFID Cards Overview")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Find RFID CARD
			 WebElement table1 = driver.findElement(By.className("content"));

			// Now get all the TR elements from the table
			java.util.List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
			// And iterate over them, getting the cells
			for (WebElement row1 : allRows1) {
			java.util.List<WebElement> cells1 = row1.findElements(By.tagName("td"));
			for (WebElement cell1 : cells1) {
			while(cell1.getText()== token);
			{
	        try{
			Thread.sleep(1500);
			//When is found the RFID CARD delete it
			driver.findElement(By.cssSelector("span.icon-trash")).click();
			
			}catch(Exception e)
			{
			System.out.println(e);
			    }
	        driver.findElement(By.name("delete")).click();
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
		  		test = true;
			
	  }
}

		


