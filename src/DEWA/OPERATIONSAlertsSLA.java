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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OPERATIONSAlertsSLA {
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
	     //Go to OPERATIONS Tab
		driver.findElement(By.id("operations")).click();
		driver.findElement(By.linkText("Open Clearing House")).isDisplayed();
		driver.findElement(By.linkText("On Call")).isDisplayed();
		driver.findElement(By.linkText("Maintenance")).isDisplayed();
		driver.findElement(By.linkText("Work Orders")).isDisplayed();
		driver.findElement(By.linkText("Alerts")).isDisplayed();

		//Go to Alerts
		try{
		Thread.sleep(1500);
		WebElement menu = driver.findElement(By.linkText("Alerts"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		driver.findElement(By.linkText("SLA")).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//Add SLA
		try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("span.icon-plus-sign")).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//Choose organisation
		try{
		Thread.sleep(1500);
		WebElement orgdrop = driver.findElement(By.cssSelector("div.input-group > select[name='organisation']"));
	    Select org = new Select(orgdrop);
		org.selectByVisibleText("TEST");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Choose SLA Profile
		try{
		Thread.sleep(1500);
		//WebElement SLAdrop = driver.findElement(By.cssSelector("div.col-md-8 > div.input-group"));
		WebElement SLAdrop = driver.findElement(By.name("slaProfile"));
		Select SLA = new Select(SLAdrop);
		SLA.selectByVisibleText("HIGH");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Choose Event Priority
		try{
		Thread.sleep(1500);
		WebElement eventdrop = driver.findElement(By.name("eventPriority"));
		Select event = new Select(eventdrop);
		event.selectByVisibleText("Information");
		}catch(Exception e)
	    {
		System.out.println(e);
		}
		//Choose Alert Content Profile
		try{
		Thread.sleep(1500);
		WebElement alertdrop = driver.findElement(By.name("alertContentProfile"));
		Select alert = new Select(alertdrop);
		alert.selectByVisibleText("alert1");
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
			System.out.println("Alert Content Profile is created");
			test = true;
		}
		else
		{
			System.out.println("Alert Content Profile is created");
			
		}
		//Edit the SLA created
		try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("span.icon-pencil")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Close the modal
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("close_slaProfile")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Delete SLA created
		try{
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("span.icon-remove")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		  }
}
