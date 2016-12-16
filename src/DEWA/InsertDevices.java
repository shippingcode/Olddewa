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

public class InsertDevices {
	String devicename[] = {"device06", "device02", "device03", "device04", "device04", "device05"};
	boolean test =false;
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

			//Choose owner from menu drop down list
			try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.name("organisation"));
			    Select org = new Select(orgdropdown);
			   org.selectByVisibleText("DEWA");
			}catch(Exception e)
			{
				System.out.println(e);
				}

			int i=0;

			while (i<=5)
					{

			//Go to Devices -> List
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("devices")).click();
			driver.findElement(By.linkText("List")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			driver.findElement(By.id("dev")).click();


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
				driver.findElement(By.name("deviceName")).sendKeys((devicename[i]));
				WebElement makedropdown = driver.findElement(By.id("organisationId"));
			    Select organisationID = new Select(makedropdown);
			   organisationID.selectByVisibleText("CIRCONTROL");
			}catch(Exception e)
			{
				System.out.println(e);
				}

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
			WebElement ownerdropdown = driver.findElement(By.name("organisation"));
			Select id1e = new Select(ownerdropdown);
			id1e.selectByVisibleText("DEWA");
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

		/*	//Add address
			try{
				Thread.sleep(1500);
			driver.findElement(By.cssSelector("div.col-md-12 > div.col-md-2 > #dev > span")).click();
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Insert address
			try{
				Thread.sleep(1500);
			driver.findElement(By.id("pac-input")).sendKeys("Strada General Berthelot");
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Select address from auto complete list
			try{
				Thread.sleep(1500);
			WebElement addressdropdown1 = driver.findElement(By.id("pac-input"));
		    Select address1 = new Select(addressdropdown1);
		    address1.selectByVisibleText("Strada General Berthelot, Bucharest, Romania");
		     }catch(Exception e)
			{
				System.out.println(e);
			}
			try{
				Thread.sleep(1500);
			driver.findElement(By.id("btn_useonlycoordinates")).click();
			}catch(Exception e)
			{
				System.out.println(e);
			} */

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
			i++;
					}

			int k = 0;
			while (k<=5){

			//Go to DEVICES Tab
			try{
				Thread.sleep(1500);
			driver.findElement(By.id("devices")).click();
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Search for device already created
			try{
				Thread.sleep(1500);
			driver.findElement(By.id("search2")).sendKeys(devicename[k]);
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
			k++;
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






