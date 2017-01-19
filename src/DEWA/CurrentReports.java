/* Create Current Report */

package DEWA;

import org.testng.annotations.Test; 
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.IOException;
  import java.util.Properties;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.firefox.FirefoxDriver;
  import org.openqa.selenium.support.ui.Select;

  public class CurrentReports  {
  	boolean test=false;
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
  			
  			//Go to  REPORTS Tab
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.id("reports"));
  			driver.findElement(By.linkText("Scheduled Reports")).isDisplayed();
  			driver.findElement(By.linkText("Distribution Group")).isDisplayed();
  			driver.findElement(By.linkText("Current Report")).isDisplayed();
  			driver.findElement(By.linkText("Report Vault")).isDisplayed();
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			//Go to Scheduled Reports
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.linkText("Current Report")).click();
  			}catch(Exception e)
  			{
  				System.out.println(e);
  			}
  			
  			  			
  			//Select Report Type
  			try{
  			Thread.sleep(1500);
  			WebElement reportdropdown = driver.findElement(By.name("reportType"));
  			Select report = new Select(reportdropdown);
  			report.selectByVisibleText("Chargepoint Last Communication Report");
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			
  			//Generate XLS & PDF formats
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.name("generateExcel")).click();
  			driver.findElement(By.name("generatePDF")).click();
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			
  		    //Select Report Type
  			try{
  			Thread.sleep(1500);
  			WebElement reportdropdown = driver.findElement(By.name("reportType"));
  			Select report = new Select(reportdropdown);
  			report.selectByVisibleText("Usage Patterns Report - Energy");
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			
  			//Generate XLS & PDF formats
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.name("generateExcel")).click();
  			driver.findElement(By.name("generatePDF")).click();
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			
  			
  			 //Select Report Type
  			try{
  			Thread.sleep(1500);
  			WebElement reportdropdown = driver.findElement(By.name("reportType"));
  			Select report = new Select(reportdropdown);
  			report.selectByVisibleText("Usage Patterns Report – Charge Cycles");
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			
  			//Generate XLS & PDF formats
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.name("generateExcel")).click();
  			driver.findElement(By.name("generatePDF")).click();
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			
  			 //Select Report Type
  			try{
  			Thread.sleep(1500);
  			WebElement reportdropdown = driver.findElement(By.name("reportType"));
  			Select report = new Select(reportdropdown);
  			report.selectByVisibleText("Usage Patterns Report – Availability Time");
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			
  			//Generate XLS & PDF formats
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.name("generateExcel")).click();
  			driver.findElement(By.name("generatePDF")).click();
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

