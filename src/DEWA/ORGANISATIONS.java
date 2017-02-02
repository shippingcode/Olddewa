
/*Implement test for ORGANISATION Tab contains:
- login
- create new organisation
- create device, motorist user & token under it
- open the organization & check each tab if contains device, motorist user & token created
- delete organization
- logout*/

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

public class ORGANISATIONS {
	String owner = GenerateData.generateRandomString(5);
	String motorist = GenerateData.generateRandomString(5);
	String token = GenerateData.generateRandomAlphaNumeric(5);
	String info = GenerateData.generateRandomAlphaNumeric(5);
    String device = GenerateData.generateRandomAlphaNumeric(5);
	boolean test=false;

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
		//driver.findElement(By.name("organisationName")).sendKeys(owner);
		driver.findElement(By.cssSelector("div.col-md-12 > input[name='organisationName']")).sendKeys(owner);
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Choose alarm
		try{
			Thread.sleep(1500);
			WebElement alarmdropdown = driver.findElement(By.cssSelector("div.col-md-12 > select[name='alertContentProfile']"));
			Select alarm = new Select(alarmdropdown);
			 alarm.selectByVisibleText("alert1");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//Choose license
		try{
			Thread.sleep(1500);
		WebElement licensedrop = driver.findElement(By.cssSelector("div.col-md-12 > select[name='license']"));
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
		driver.findElement(By.name("ochpOperatorId")).sendKeys("34");
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
		//Choose organisation 
		try{
		Thread.sleep(1500);
		WebElement orgdropdown = driver.findElement(By.name("organisation"));
		Select org = new Select(orgdropdown);
		org.selectByVisibleText(owner);
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		//Go to DEVICES Tab
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("devices")).click();
		driver.findElement(By.linkText("List")).isDisplayed();
		driver.findElement(By.linkText("List")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Click on Add new device
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("Add")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Modal window is displayed & add new device
		try{
		Thread.sleep(1500);
		//Check for modal window is displayed
		driver.findElement(By.className("modal-dialog")).isDisplayed();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Fill a device name
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("deviceName")).sendKeys(device);
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Choose Make
		try{
		Thread.sleep(1500);
		}catch(Exception e)
		{
		System.out.println(e);
		}
		WebElement makedropdown = driver.findElement(By.id("organisationId"));
		Select make = new Select(makedropdown);
		make.selectByVisibleText("CIRCONTROL");
		//Choose model
		try{
		Thread.sleep(1500);
		WebElement modeldropdown = driver.findElement(By.id("equipmentType"));
		Select equipmentType = new Select(modeldropdown);
		equipmentType.selectByVisibleText("CCL");
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Choose Owner
		try{
			Thread.sleep(1500);
		//WebElement orgdropdown = driver.findElement(By.cssSelector("div.uniform > select[name='organisation']"));
		WebElement orgdropdown = driver.findElement(By.name("organisation"));
		Select organisation = new Select(orgdropdown);
		organisation.selectByVisibleText(owner);
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Add status
		try{
		Thread.sleep(1500);
		WebElement statusdropdown = driver.findElement(By.name("userAppliedStatusType"));
		Select status = new Select(statusdropdown);
		status.selectByVisibleText("Operative");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		//Fill Offline & Maintenance interval
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("offlineThresholdMins")).sendKeys("15");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("maintenanceIntervalOverrideMonths")).sendKeys("15");
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Press Save
		try{
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@class='btn btn-success btn-clean']")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Go to RFID CARDS
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("rfid")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Go to RFID Cards Overview
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("RFID Cards Overview")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Click on Add
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("Add")).click();
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
		card.selectByVisibleText("REMvtoken");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Fill token
		driver.findElement(By.name("token")).sendKeys(token);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		//Fill token info
		driver.findElement(By.name("info")).sendKeys(info);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		//Choose organization
		 WebElement orgdropdown = driver.findElement(By.name("creatorOrganisation"));
		 driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		 Select organisation = new Select(orgdropdown);
		 organisation.selectByVisibleText(owner);
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Save all the info
		 try{
		Thread.sleep(1500);
		driver.findElement(By.id("save_eventrecord")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Verify if success message is displayed
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("successAlert")).isDisplayed();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		
		//Go to RFID CARDS
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("rfid")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Go to Motorist sub-menu
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("Motorist")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Add motorist
		try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("span.icon-plus")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Fill Name
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("userName")).sendKeys(motorist);
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Choose organization
		try{
		Thread.sleep(1500);
		WebElement org1dropdown = driver.findElement(By.id("organisationUserRfid"));
		Select org1 = new Select(org1dropdown);
		org1.selectByVisibleText(owner);
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Choose membership
		try{
		Thread.sleep(1500);
		WebElement memdropdown = driver.findElement(By.name("memType"));
		Select mem = new Select(memdropdown);
		mem.selectByVisibleText("Annual");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Fill phone
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("phoneNumber")).sendKeys("234567894444");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		
		//Fill email address
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("emailPrimary")).sendKeys("aila.bogasieru@gmail.com");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		//License no
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("licenseNumber")).sendKeys("21345678934567");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		//Vehicle
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("vehicleType")).sendKeys("car");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		//Save
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("save_assignment")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		
		//Go to ORGANISATIONS Tab
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("topmenu_organisation")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
	
		//Find organisation already created in the table of organisations
		 WebElement table = driver.findElement(By.className("content"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
		java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
		for (WebElement cell : cells) {
		while(cell.getText()== owner);
		{
        try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("span.icon-search")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		     }
		   }
	    	}
		}
		//For owner org click open
		try{
		Thread.sleep(1500);
		
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Go to TAG/TOKEN Tab
		driver.findElement(By.linkText("TAG/TOKEN")).click();
		//Search the token already created
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("search2")).sendKeys(token);
		}catch(Exception e)
        {
	    System.out.println(e);
        }
		//Press Search button
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("btnSearch")).click();
		}catch(Exception e)
        {
	    System.out.println(e);
        }
		//Go to Unassigned Tab
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("tab_stock")).click();
		}catch(Exception e)
        {
	    System.out.println(e);
        }
		//Check result is displayed
		driver.findElement(By.xpath("//*[@id='table table-bordered table-striped']/table[1]/tbody/tr[1]/td[1]")).isDisplayed();

		//Go to USER Tab
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("USER")).click();
	    }catch(Exception e)
		{
        System.out.println(e);
        }
		//Search user already created
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("search2")).sendKeys(motorist);
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
		//Delete the org
		
		//Find organisation already created in the table of organisations
		 WebElement table1 = driver.findElement(By.className("content"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row1 : allRows1) {
		java.util.List<WebElement> cells1 = row1.findElements(By.tagName("td"));
		for (WebElement cell1 : cells1) {
		while(cell1.getText()== owner);
		{
       try{
		Thread.sleep(1500);
		driver.findElement(By.className("widget-icon widget-icon-circle")).click();
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
		test=true;


	}
}







