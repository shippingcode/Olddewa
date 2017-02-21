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

public class CreateRoles {
	 boolean test=false;
		GenerateData genData = null;
		static WebDriver driver = null;
		String firstname = GenerateData.generateRandomString(5);
		String surname = GenerateData.generateRandomString(5);
		String username = GenerateData.generateRandomAlphaNumeric(5);
		String  phone = GenerateData.generateRandomNumber(10);
		 public static WebElement userdropdown = null;
		 public static WebElement orgdropdown = null;
		 String email = GenerateData.generateEmail(10);
		 String licenseno = GenerateData.generateRandomNumber(10);
					
 		@Test
		 public void createroles() throws FileNotFoundException {
 			
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
			//Go to Settings -> Add user system
			driver.findElement(By.cssSelector("span.icon-cog")).click();
			driver.findElement(By.linkText("My profile")).isDisplayed();
			driver.findElement(By.linkText("System Users")).isDisplayed();
			//Go to User System
			try{
			Thread.sleep(1500);
			driver.findElement(By.linkText("System Users")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Create Admin Role
			//Click on Add System User
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("actionsMenu")).click();
			driver.findElement(By.linkText("Add")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill First Name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("firstName")).sendKeys(firstname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill Last name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("surname")).sendKeys(surname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill username
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("userName")).sendKeys(username);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Choose Role
			try{
			Thread.sleep(1500);
			userdropdown = driver.findElement(By.cssSelector("div.col-md-6 > select[name='userLevel']"));
			Select user = new Select(userdropdown);
			user.selectByVisibleText("Admin");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Choose organization
			try{
			Thread.sleep(1500);
			orgdropdown = driver.findElement(By.cssSelector("div.col-md-6 > select[id='organisationUserSysId']"));
			Select org = new Select(orgdropdown);
			org.selectByVisibleText("TEST");
			}catch(Exception e)
			{
			System.out.println(e);
			}
	 		//Fill phone number
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("phoneNumber")).sendKeys(phone);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill email
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("emailPrimary")).sendKeys(email);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("licenseNumber")).sendKeys(licenseno);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill vehicle type
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("vehicleType")).sendKeys("car");
			}catch(Exception e)
			{
			System.out.println(e);
			}
		
			//Choose membership
			try{
			Thread.sleep(1500);
			WebElement membershipdropdown = driver.findElement(By.name("memType"));
			Select mem = new Select(membershipdropdown);
			mem.selectByVisibleText("Monthly");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Press Save Button
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("save_assignment")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Perform Search
			try{
			Thread.sleep(5000);
			driver.findElement(By.id("search")).sendKeys(username);
			driver.findElement(By.id("btnSearch")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Create Default Role			
			//Click on Add System User
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("actionsMenu")).click();
			driver.findElement(By.linkText("Add")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill First Name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("firstName")).sendKeys(firstname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill Last name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("surname")).sendKeys(surname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill username
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("userName")).sendKeys(username);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Choose Role
			try{
			Thread.sleep(1500);
			Select user1 = new Select(userdropdown);
			user1.selectByVisibleText("Default");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Choose organization
			try{
			Thread.sleep(1500);
			Select org1 = new Select(orgdropdown);
			org1.selectByVisibleText("TEST");
			}catch(Exception e)
			{
			System.out.println(e);
			}
	 		//Fill phone number
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("phoneNumber")).sendKeys(phone);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill email
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("emailPrimary")).sendKeys(email);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("licenseNumber")).sendKeys(licenseno);
			}catch(Exception e)
			{
			System.out.println(e);
			}
		
			//Fill vehicle type
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("vehicleType")).sendKeys("car");
			}catch(Exception e)
			{
			System.out.println(e);
			}
		
			//Choose membership
			try{
			Thread.sleep(1500);
			WebElement membershipdropdown = driver.findElement(By.name("memType"));
			Select mem = new Select(membershipdropdown);
			mem.selectByVisibleText("Monthly");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Press Save Button
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("save_assignment")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Perform Search
			try{
			Thread.sleep(5000);
			driver.findElement(By.id("search")).sendKeys(username);
			driver.findElement(By.id("btnSearch")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			/*No longer applicable from GUI
			//Create HubelonSysAdmin Role		
			//Click on Add System User
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("actionsMenu")).click();
			driver.findElement(By.linkText("Add")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill First Name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("firstName")).sendKeys(firstname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill Last name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("surname")).sendKeys(surname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill username
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("userName")).sendKeys(username);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Choose Role
			try{
			Thread.sleep(1500);
			Select user = new Select(userdropdown);
			user.selectByVisibleText("HubelonSysAdmin");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Choose organization
			try{
			Thread.sleep(1500);
			Select org2 = new Select(orgdropdown);
			org2.selectByVisibleText("TEST");
			}catch(Exception e)
			{
			System.out.println(e);
			}
	 		//Fill phone number
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("phoneNumber")).sendKeys(phone);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill email
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("emailPrimary")).sendKeys(email);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("licenseNumber")).sendKeys(licenseno);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill vehicle type
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("vehicleType")).sendKeys("car");
			}catch(Exception e)
			{
			System.out.println(e);
			}
	
			//Choose membership
			try{
			Thread.sleep(1500);
			WebElement membershipdropdown = driver.findElement(By.name("memType"));
			Select mem = new Select(membershipdropdown);
			mem.selectByVisibleText("Monthly");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Press Save Button
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("save_assignment")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Perform Search
			try{
			Thread.sleep(5000);
			driver.findElement(By.id("search")).sendKeys(username);
			driver.findElement(By.id("btnSearch")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			*/
			//Create Technician Role
			//Click on Add System User
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("actionsMenu")).click();
			driver.findElement(By.linkText("Add")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill First Name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("firstName")).sendKeys(firstname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
		
			//Fill Last name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("surname")).sendKeys(surname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill username
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("userName")).sendKeys(username);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Choose Role
			try{
			Thread.sleep(1500);
			Select user3 = new Select(userdropdown);
			user3.selectByVisibleText("Manager");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Choose organization
			try{
			Thread.sleep(1500);
			Select org3 = new Select(orgdropdown);
			org3.selectByVisibleText("TEST");
			}catch(Exception e)
			{
			System.out.println(e);
			}
	 		//Fill phone number
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("phoneNumber")).sendKeys(phone);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill email
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("emailPrimary")).sendKeys(email);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("licenseNumber")).sendKeys(licenseno);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill vehicle type
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("vehicleType")).sendKeys("car");
			}catch(Exception e)
			{
			System.out.println(e);
			}
		
			//Choose membership
			try{
			Thread.sleep(1500);
			WebElement membershipdropdown = driver.findElement(By.name("memType"));
			Select mem = new Select(membershipdropdown);
			mem.selectByVisibleText("Monthly");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Press Save Button
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("save_assignment")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Perform Search
			try{
			Thread.sleep(5000);
			driver.findElement(By.id("search")).sendKeys(username);
			driver.findElement(By.id("btnSearch")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Create Technician Role
			//Click on Add System User
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("actionsMenu")).click();
			driver.findElement(By.linkText("Add")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill First Name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("firstName")).sendKeys(firstname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill Last name
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("surname")).sendKeys(surname);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill username
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("userName")).sendKeys(username);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Choose Role
			try{
			Thread.sleep(1500);
			Select user4 = new Select(userdropdown);
			user4.selectByVisibleText("Technician");
			}catch(Exception e)
			{
			System.out.println(e);
			}
		
			//Choose organization
			try{
			Thread.sleep(1500);
			Select org4 = new Select(orgdropdown);
			org4.selectByVisibleText("TEST");
			}catch(Exception e)
			{
			System.out.println(e);
			}
	 		//Fill phone number
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("phoneNumber")).sendKeys(phone);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Fill email
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("emailPrimary")).sendKeys(email);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("licenseNumber")).sendKeys(licenseno);
			}catch(Exception e)
			{
			System.out.println(e);
			}
			
			//Fill vehicle type
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("vehicleType")).sendKeys("car");
			}catch(Exception e)
			{
			System.out.println(e);
			}
		
			//Choose membership
			try{
			Thread.sleep(1500);
			WebElement membershipdropdown = driver.findElement(By.name("memType"));
			Select mem = new Select(membershipdropdown);
			mem.selectByVisibleText("Monthly");
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Press Save Button
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("save_assignment")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Perform Search
			try{
			Thread.sleep(5000);
			driver.findElement(By.id("search")).sendKeys(username);
			driver.findElement(By.id("btnSearch")).click();
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
			
		



