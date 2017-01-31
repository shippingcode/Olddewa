/* Add a new device with new model, new connectors with Operative status and check the status of the device*/
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

public class AddAndCheckDeviceStatusOperative {
	boolean test = false;
	GenerateData genData = null;
	String device = GenerateData.generateRandomString(20);
	String make = GenerateData.generateRandomAlphaNumeric(5);
	String equipmentname = GenerateData.generateRandomAlphaNumeric(5);
	String model = GenerateData.generateRandomAlphaNumeric(5);
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
			//System.setProperty("webdriver.chrome.driver", "C://Users/Aila/Downloads/chromedriver.exe");
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
			
			//Go to List
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("devices")).click();
			driver.findElement(By.linkText("List")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			driver.findElement(By.cssSelector("span.icon-plus")).click();
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
			//Add new make
			try{
			Thread.sleep(1500);
			driver.findElement(By.cssSelector("div.col-md-2 > #dev > span")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Add new Make name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("organisation.organisationName")).sendKeys(make);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Add new Equipment type
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("equipmentTypeName")).sendKeys(equipmentname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Add model name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("equipmentTypeModel")).sendKeys(model);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill maintenance interval (months)
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("maintenanceIntervalMonths")).sendKeys("12");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Choose protocol
			try{
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(By.cssSelector("div.col-md-6 > select[name='protocol']"));
			Select organisation = new Select(orgdropdown);
			organisation.selectByVisibleText("OCPP 1.5");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Add connectors
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("addConnector")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Add 1st connector
			//Fill connector name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:0:localConnectorLocation")).sendKeys("conn1");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Select connector's type
			try{
			Thread.sleep(1500);
			WebElement conntypedrop = driver.findElement(By.name("connectorEquipmentRelationships:0:connectorType"));
			Select conntype = new Select(conntypedrop);
		    conntype.selectByVisibleText("ChaDeMo");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector's no
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:0:localConnectorId")).sendKeys("1");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Add 2nd connector
			//Add connectors
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("addConnector")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:1:localConnectorLocation")).sendKeys("conn2");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Select connector's type
			try{
			Thread.sleep(1500);
			WebElement conntypedrop = driver.findElement(By.name("connectorEquipmentRelationships:1:connectorType"));
			Select conntype = new Select(conntypedrop);
			conntype.selectByVisibleText("Combo CCS");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector's no
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:1:localConnectorId")).sendKeys("2");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Add 3rd connector
			//Add connectors
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("addConnector")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:2:localConnectorLocation")).sendKeys("conn3");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Select connector's type
			try{
			Thread.sleep(1500);
			WebElement conntypedrop = driver.findElement(By.name("connectorEquipmentRelationships:2:connectorType"));
			Select conntype = new Select(conntypedrop);
			conntype.selectByVisibleText("J1772");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector's no
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:2:localConnectorId")).sendKeys("3");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Add 4th connector
			//Add connectors
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("addConnector")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:3:localConnectorLocation")).sendKeys("conn4");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Select connector's type
			try{
			Thread.sleep(1500);
			WebElement conntypedrop = driver.findElement(By.name("connectorEquipmentRelationships:3:connectorType"));
			Select conntype = new Select(conntypedrop);
			conntype.selectByVisibleText("Combined ChaDeMo/ComboCCS");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector's no
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:3:localConnectorId")).sendKeys("4");
			}catch(Exception e)
			{
			System.out.println(e);
			}

			//Add 5th connector
			//Add connectors
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("addConnector")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:4:localConnectorLocation")).sendKeys("conn5");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Select connector's type
			try{
			Thread.sleep(1500);
			WebElement conntypedrop = driver.findElement(By.name("connectorEquipmentRelationships:4:connectorType"));
			Select conntype = new Select(conntypedrop);
			conntype.selectByVisibleText("BS1363 (3 pin UK)");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill connector's no
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("connectorEquipmentRelationships:4:localConnectorId")).sendKeys("5");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Press Save make
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("save_make")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Choose organisation
			try{
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(By.cssSelector("div.col-md-6 > select[name='organisation']"));
			Select org = new Select(orgdropdown);
			org.selectByVisibleText("TEST");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Select User applied status type
			try{
			Thread.sleep(1500);
			WebElement timezonedropdown = driver.findElement(By.name("userAppliedStatusType"));
			Select timezone = new Select(timezonedropdown);
			timezone.selectByVisibleText("Operative");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			/*//Add/Edit address
			try{
		    Thread.sleep(1500);
		    driver.findElement(By.cssSelector("div.col-md-12 > div.col-md-2 > #dev > span")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
		    //Enter an address
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("pac-input")).sendKeys("Strada Popa Tatu, Bucharest, Romania");
			WebElement addressdrop = driver.findElement(By.id("pac-input"));
			WebElement menu = driver.findElement(By.id("pac-input"));
			Select address = new Select(addressdrop);
			Actions actions = new Actions(driver);
			actions.moveToElement(menu).perform();
			address.selectByVisibleText("Strada Popa Tatu, Bucharest, Romania");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Choose language
			try{
			Thread.sleep(1500);
			WebElement languagedrop = driver.findElement(By.id("siteLanguage"));
			Select language = new Select(languagedrop);
			language.selectByVisibleText("Romanian");
			}catch(Exception e)
			{
			System.out.println(e);
			}
	        //Save address
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("save_site")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}*/
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
			//Go to DEVICES Tab
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("devices")).click();
			driver.findElement(By.linkText("List")).isDisplayed();
			driver.findElement(By.linkText("Map")).isDisplayed();
			driver.findElement(By.linkText("Events")).isDisplayed();
			driver.findElement(By.linkText("Overview")).isDisplayed();
			}catch(Exception e)
			{
				System.out.println(e);
				}
			//Search for device already created
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("search2")).sendKeys(device);
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
			if(driver.getPageSource().contains("Unknown"))
					{
				test = true;
				System.out.println("Device's status is in Unknown");
			}
			else
			{
				System.out.println("Device has wrong status");
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












