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

public class SearchUnassignedTokenToUser {

	String token = GenerateData.generateRandomAlphaNumeric(5);
	String info = GenerateData.generateRandomAlphaNumeric(5);
	boolean test = false;
	@Test
	public void searchunassignedtokentouser()  throws FileNotFoundException {
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
		try{
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(By.name("creatorOrganisation"));
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			Select organisation = new Select(orgdropdown);
			organisation.selectByVisibleText("TEST");
		}catch(Exception e)
		{
			System.out.println(e);
		}

		//Check the checkbox for OCHP Enabled
		try{
			Thread.sleep(1500);
			driver.findElement(By.xpath("//input[@name='ochpEnabled']")).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}

		//Choose OCHP Type
		try{
			Thread.sleep(1500);
			WebElement ochpdropdown = driver.findElement(By.name("ochpType"));
			Select ochp = new Select(ochpdropdown);
			ochp.selectByVisibleText("rfid");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//Choose OCHP Subtype
		try{
			Thread.sleep(1500);
			WebElement ochpsubtypedropdown = driver.findElement(By.name("ochpSubtype"));
			Select ochpsubtype = new Select(ochpsubtypedropdown);
			ochpsubtype.selectByVisibleText("calypso");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//Choose OCHP Representation
		try{
			Thread.sleep(1500);
			WebElement ochprepresdropdown = driver.findElement(By.name("ochpTokenRepresentation"));
			Select ochprepres = new Select(ochprepresdropdown);
			ochprepres.selectByVisibleText("sha-160");
		}catch(Exception e)
		{
			System.out.println(e);
		}
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
		//Check the device's status
		//Find organisation already created in the table of organisations
		WebElement table = driver.findElement(By.className("content"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				while(cell.getText()== token)
				{
					try{
						Thread.sleep(1500);
						driver.findElement(By.name("tab_stock")).isDisplayed();
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
		test = true;
	}
}
