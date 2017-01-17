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

public class RFIDCARDS_RFIDCardsOperations {
	boolean test = false;

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

		//Go to RFID CARDS
		try{
			Thread.sleep(1500);
		driver.findElement(By.id("rfid")).click();
		driver.findElement(By.linkText("RFID Cards Overview")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Add RFID CARD
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("actAddCard")).click();
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
		driver.findElement(By.name("token")).sendKeys("tokenSelenium1010");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		//Fill token info
		driver.findElement(By.name("info")).sendKeys("infoSel000");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		//Choose organization
		WebElement orgdropdown = driver.findElement(By.name("creatorOrganisation"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select organisation = new Select(orgdropdown);
		organisation.selectByVisibleText("TEST");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("ochpContractId")).sendKeys("123454");
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
	//search for a token
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("search2")).sendKeys("tokenSelenium1010");
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
	 //Assign token
	 //Find token already created in the table of assigned
	 WebElement table2 = driver.findElement(By.className("content"));
	java.util.List<WebElement> allRows2 = table2.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row2 : allRows2) {
	java.util.List<WebElement> cells2 = row2.findElements(By.tagName("td"));
	for (WebElement cell2 : cells2) {
	while(cell2.getText()== "tokenSelenium1010");{
	try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-user")).click();
	}catch(Exception e)
		{
		 System.out.println(e);
		}
	//Select user
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("userName")).sendKeys("Selenium");
		WebElement userdrop = driver.findElement(By.name("userName"));
		Select user1 = new Select(userdrop);
		user1.selectByVisibleText("SeleniumMotorist");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//Press Save
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("save_assignment")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		  }
		    }
	}
    //Find token already created in the table of assigned
	 WebElement table = driver.findElement(By.className("content"));

	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows) {
	java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	for (WebElement cell : cells) {
	while(cell.getText()== "tokenSelenium1010");{
	try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-user")).click();
	driver.findElement(By.name("bar")).click();
	}catch(Exception e)
	{
	 System.out.println(e);
	}
	  }
	    }
	}
  	//search the barred token
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("search2")).sendKeys("tokenSelenium1010");
	driver.findElement(By.id("btnSearch")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Go to Blacklisted Tab
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("tab_black")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	 WebElement table1 = driver.findElement(By.className("content"));
	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
	for (WebElement row1 : allRows1) {
	java.util.List<WebElement> cells1 = row1.findElements(By.tagName("td"));
	for (WebElement cell1 : cells1) {
	while(cell1.getText()== "tokenSelenium1010");
	{
		driver.findElement(By.cssSelector("a.widget-icon widget-icon-circle > span.icon-ban-circle")).click();
		driver.findElement(By.name("un-bar")).click();
		}
  }
}
	//Go to Whitelisted Tab
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("tab_white")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}

	 WebElement table5 = driver.findElement(By.className("content"));
		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows5 = table5.findElements(By.tagName("tr"));
		for (WebElement rows5 : allRows5) {
		java.util.List<WebElement> cells5 = rows5.findElements(By.tagName("td"));
		for (WebElement cell5 : cells5) {
		while(cell5.getText()== "tokenSelenium1010");
		driver.findElement(By.className("icon-trash")).click();
		driver.findElement(By.name("delete")).click();
		test = true;
		}
	  }
	}

}



