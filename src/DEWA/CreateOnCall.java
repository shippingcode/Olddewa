/* Create On Call */

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

public class CreateOnCall {
	boolean test = false;

	@Test
	public void createOnCall() throws FileNotFoundException {
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
			WebElement devicedrop = driver.findElement(By.name("user"));
			Select device = new Select(devicedrop);
			device.selectByVisibleText("test.admin");
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

		if(driver.getPageSource().contains("Success! The register was saved/update successfully"))
		{
			test = true;
			System.out.println ("On Call was created with success");

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

