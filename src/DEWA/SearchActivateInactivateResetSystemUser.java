/* Search System user */

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
import DEWA.GenerateData;



public class SearchActivateInactivateResetSystemUser{
	boolean test=false;
	WebDriver driver = null;
	GenerateData genData = null;
	String firstname = GenerateData.generateRandomString(5);
	String surname = GenerateData.generateRandomString(5);
	String phone = GenerateData.generateRandomNumber(10);
	String username = GenerateData.generateRandomAlphaNumeric(5);

	@Test
	 public void searchsystemuserwithactions() throws FileNotFoundException {
		//Login

		  Properties prop = new Properties();
		  FileInputStream file = new FileInputStream("C:\\Users\\Aila\\workspace\\dewa\\src\\DEWA\\datadriven.properties");
	      try {
			prop.load(file);
		} catch (IOException e1) {
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
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Fill Last name
		driver.findElement(By.name("surname")).sendKeys(surname);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Fill username
		driver.findElement(By.name("userName")).sendKeys(username);
		//Choose Role
		WebElement userdropdown = driver.findElement(By.name("userLevel"));
		Select user = new Select(userdropdown);
		user.selectByVisibleText("Technician");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Choose organization
		WebElement orgdropdown =  driver.findElement(By.cssSelector("div.col-md-6 > select[name='organisation']"));
		Select org = new Select(orgdropdown);
		org.selectByVisibleText("TEST");

 		//Fill phone number
		driver.findElement(By.name("phoneNumber")).sendKeys(phone);
		//Fill email
		driver.findElement(By.name("emailPrimary")).sendKeys("abogasieru@yahoo.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("licenseNumber")).sendKeys("123567892");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Fill vehicle type
		driver.findElement(By.name("vehicleType")).sendKeys("car");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		//Inactivate the user
		try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("span.icon-lock")).click();
		driver.findElement(By.name("btnChangeStatus")).click();
		
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
			System.out.println("System user was inactived with success");
		

		//Activate the user
		try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("span.icon-unlock")).click();
		driver.findElement(By.name("btnChangeStatus")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}

	   System.out.println("System user was activated with success");


		//Reset password
		try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("span.icon-key")).click();
		driver.findElement(By.name("ajxResetPassword")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		
		System.out.println("user password was reseted successfully");
			
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
