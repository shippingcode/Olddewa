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

public class CreateMakerModel {
	boolean test = false;
	GenerateData genData = null;
	String device = GenerateData.generateRandomString(20);
	String make = GenerateData.generateRandomAlphaNumeric(5);
	String equipmentname = GenerateData.generateRandomAlphaNumeric(5);
	String model = GenerateData.generateRandomAlphaNumeric(5);
	@Test
	 public void addcheckoperative() throws FileNotFoundException {
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
	  			//WebDriver driver = new ChromeDriver();
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
	  		//Choose organisation 
				try{
					Thread.sleep(1500);
					WebElement orgdropdown = driver.findElement(By.name("organisation"));
					Select org = new Select(orgdropdown);
					 org.selectByVisibleText("TEST");
				}catch(Exception e)
				{
					System.out.println(e);
				}
	  		
	  		//Click on toggle content
	  		try{
	  		Thread.sleep(1500);
	  		driver.findElement(By.cssSelector("span.icon-chevron-up")).click();
	  				
	  	}catch(Exception e)
	  	{
	  		System.out.println(e);
	  		}
	  		//Click on Add Edit Maker
	  		try{
	  		Thread.sleep(1500);
	  		driver.findElement(By.cssSelector("span.icon-user")).click();
	  			
	  		}catch(Exception e)
	  		{
	  			System.out.println(e);
	  			}
	  		//Press New Button
	  		try{
		  	Thread.sleep(1500);
		   	//driver.getPageSource().contains("New");
			driver.findElement(By.xpath("//button[contains(text(),'New']")).click();
						
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
			
			//Switch back to TEST organisation
			try{
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(By.name("organisation"));
			Select org = new Select(orgdropdown);
			 org.selectByVisibleText("TEST");
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
	  }
}
