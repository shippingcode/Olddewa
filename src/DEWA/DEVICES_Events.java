
/* Add sub-menu Events from DEVICES Tab */
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

public class DEVICES_Events {
    boolean test = false;

    @Test
    public void DeviceEvents() throws FileNotFoundException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Aila\\workspace\\dewa\\src\\DEWA\\datadriven.properties");
        try {
            prop.load(file);
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        WebDriver driver = new FirefoxDriver(); 
        //System.setProperty("webdriver.chrome.driver", "C://Users/Aila/Downloads/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url1"));
        try {
            Thread.sleep(1500);
            driver.findElement(By.name((String)"username")).sendKeys(prop.getProperty("username1"));
            driver.findElement(By.name((String)"password")).sendKeys(prop.getProperty("password1"));
            driver.findElement(By.xpath((String)"//input[@value='Log In']")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            WebElement orgdropdown = driver.findElement(By.name("organisation"));
            Select org = new Select(orgdropdown);
            org.selectByVisibleText("TEST");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("devices")).click();
            driver.findElement(By.linkText("List")).isDisplayed();
            driver.findElement(By.linkText("Map")).isDisplayed();
            driver.findElement(By.linkText("Events")).isDisplayed();
            driver.findElement(By.linkText("Overview")).isDisplayed();
            driver.findElement(By.linkText("Location")).isDisplayed();
            driver.findElement(By.linkText("Map Location")).isDisplayed();
            driver.findElement(By.linkText("Report")).isDisplayed();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.linkText("Events")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1500);
            driver.findElement(By.name("search")).sendKeys("device1");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
         //Set start date 1st of previous month 00:00
        try {
            Thread.sleep(1500);
            driver.findElement(By.name("start")).clear();
            driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w")).click();
            driver.findElement(By.linkText("1")).click();
            driver.findElement(By.xpath("//button[@type='button'])[4]")).click();
         
            
          }
        catch (Exception e) {
            System.out.println(e);
        }
        //Set end date 1st of current date 00:00
        try {
            Thread.sleep(1500);
          driver.findElement(By.name("end")).click();
          driver.findElement(By.linkText("1")).click();
            driver.findElement(By.xpath("//button[@type='button'])[4]")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
      
       
      //Un check the checkbox for Medium & Low
		 if ( !driver.findElement(By.id("id1f3-eventPriority_1")).isSelected() )
		 {
		      driver.findElement(By.id("id1f3-eventPriority_1")).click();
		 }
	
		 if ( !driver.findElement(By.id("id1f3-eventPriority_2")).isSelected() )
		 {
		      driver.findElement(By.id("id1f3-eventPriority_2")).click();
		 }
       
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("searchEvents")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        
      //Check the device's status
		//Find organisation already created in the table of organisations
		 WebElement table = driver.findElement(By.className("table table-bordered table-striped"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
		java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
		for (WebElement cell : cells) 
		if(cell.getText()== "device1" && cell.getText()== "High")
		{
		System.out.println("Device is found with high event as priority");
		}
		else
		{
		System.out.println("Device is not found or filtering is not working"); 			
		}
		}
	//Open an event
	 try {
     Thread.sleep(1500);
     driver.findElement(By.id("panelEventDetail")).click();
       }
       catch (Exception e) {
         System.out.println(e);
        }
        
        try {
            Thread.sleep(1500);
           driver.findElement(By.id("statusDevice")).isDisplayed();
            driver.findElement(By.id("locationDevice")).isDisplayed();
            driver.findElement(By.id("controlDevice")).isDisplayed();
            driver.findElement(By.id("controlDocuments")).isDisplayed();
            driver.findElement(By.id("historyEvents")).isDisplayed();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
        Thread.sleep(1500);
        driver.findElement(By.id("locationDevice")).isDisplayed();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("controlDevice")).isDisplayed();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("controlDocuments")).isDisplayed();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        try {
            Thread.sleep(1500);
            driver.findElement(By.id("historyEvents")).isDisplayed();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        
        //Logout
        try {
            Thread.sleep(1500);
            driver.findElement(By.className("icon-eject")).click();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        test = true;
    }
}