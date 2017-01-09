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

public class OPERATIONSOpenClearingHouseClearingHouse {
	 boolean test, test1 = false;
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
	driver.findElement(By.linkText("Clearing House")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//For Review is displayed
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("tab_review_link")).isDisplayed();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Press Next
	int i=0;
	while (i<=5) {
	try{
		Thread.sleep(1500);
	driver.findElement(By.linkText("Next")).click();
	}catch(Exception e)
	{
		System.out.println(e);
		}
	i++;
}
	//Accept
	WebElement table = driver.findElement(By.id("id42"));
	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows) {
	java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	for (WebElement cell : cells)
	while(cell.getText()== "EWE3948")
	 {
		 driver.findElement(By.cssSelector("span.icon-thumbs-up")).click();
	 }
	}
	//Reject
	WebElement table1 = driver.findElement(By.id("id42"));
	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows1= table1.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows1) {
	java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	for (WebElement cell : cells)
	while(cell.getText()== "EWE3948")
	 {
		driver.findElement(By.cssSelector("span.icon-thumbs-down")).click();
	 }
	}
	//View info
	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows2= table1.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows2) {
	java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	for (WebElement cell : cells)
	while(cell.getText()== "EWE3948")
	 {
		driver.findElement(By.cssSelector("span.icon-info-sign")).click();
		//Check the modal is displayed
		driver.findElement(By.className("modal-content")).isDisplayed();
		//Close the modal window
		driver.findElement(By.xpath("//button[@type='button'])[3]")).click();
	 }
	}
	//Check the RFD is not in Accepted Tab
	driver.findElement(By.id("tab_accept_link")).click();
	java.util.List<WebElement> allRows3 = table1.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows3) {
	java.util.List<WebElement> cells3 = row.findElements(By.tagName("td"));
	for (WebElement cell : cells3) {
	do{
	driver.findElement(By.linkText("Next")).click();
	}
	while(cell.getText()!= "EWE3948");
	test = true;
	}
	}
   //Go to Rejected
	driver.findElement(By.id("tab_reject_link")).click();
	//Check the CRD is in rejected tab
	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows4 = table1.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows4) {
	java.util.List<WebElement> cells4 = row.findElements(By.tagName("td"));
	for (WebElement cell : cells4) {
	do{
	driver.findElement(By.linkText("Next")).click();
	}
	while(cell.getText()== "EWE3948");
	test1 = true;
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

