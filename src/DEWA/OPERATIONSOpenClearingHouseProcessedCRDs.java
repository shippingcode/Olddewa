package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OPERATIONSOpenClearingHouseProcessedCRDs {

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
	//Go to OPERATIONS Tab
	driver.findElement(By.id("topmenu_maintenance")).click();
	driver.findElement(By.linkText("Maintenance")).isDisplayed();
	driver.findElement(By.linkText("Open Clearing House")).isDisplayed();

	//Go to Open Clearing House
	try{
	Thread.sleep(1500);
	WebElement menu = driver.findElement(By.linkText("Open Clearing House"));
	Actions actions = new Actions(driver);
	actions.moveToElement(menu).perform();
	driver.findElement(By.linkText("Processed CDRs")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Rows are displayed into the table
	WebElement table_element = driver.findElement(By.className("content tab-content"));
	java.util.List<WebElement> tr_collection=table_element.findElements(By.xpath("id('id30')/tbody/tr"));

	System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
	int row_num,col_num;
	row_num=1;
	for(WebElement trElement : tr_collection)
	{
		java.util.List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
	    System.out.println("NUMBER OF COLUMNS="+td_collection.size());
	    col_num=1;
	    for(WebElement tdElement : td_collection)
	    {
	        System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
	        col_num++;
	    }
	    row_num++;
	    }
	//Create a filter
	//From 1-MAY Until 1-JUNE
	//Start
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("start")).click();
	driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w")).click();
	driver.findElement(By.linkText("1")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//End
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("end")).click();
	driver.findElement(By.linkText("1")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Press Filter Button
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("search")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Clear filters
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("clear_search")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}

	//Perform a search
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("chargingId")).sendKeys("testdoesnotexist");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Press Filter Button
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("search")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Check if row is being displayed
	WebElement table1 = driver.findElement(By.id("tab1"));
	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows1= table1.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows1) {
	java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	for (WebElement cell : cells)
	while(cell.getText()== "testdoesnotexist")
	 {
		driver.findElement(By.cssSelector("span.icon-info-sign")).click();
		driver.findElement(By.cssSelector("#cdrInfoModal > div.modal-dialog > div.modal-content > div.modal-header > button.bootbox-close-button.close")).click();
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

