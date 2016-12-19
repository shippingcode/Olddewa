	/* Setup Usage Patterns Report - Charge Cycles for PDF and XLS formats */

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

	public class UsagePatternsReportChargeCycles {
		boolean test=false;
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
				driver.findElement(By.linkText("Scheduled Reports")).click();
				}catch(Exception e)
				{
					System.out.println(e);
				}
				//PDF Format
				//Click on Add
				try{
				Thread.sleep(1500);
				driver.findElement(By.cssSelector("span.icon-plus")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Select organization
				try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.name("organisation"));
				Select org = new Select(orgdropdown);
				org.selectByVisibleText("TEST");
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
				//Auto Generate
				try{
				Thread.sleep(1500);
				WebElement generatedropdown = driver.findElement(By.name("reportFrequency"));
				Select generate = new Select(generatedropdown);
				generate.selectByVisibleText("Weekly");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Check the checkbox for Enable delivery report by e-mail
				try{
				Thread.sleep(1500);
				driver.findElement(By.xpath("//input[@id='overrideAuth']")).click();
				}catch(Exception e)
				{
					System.out.println(e);
				}
							
				//Select sending to
				try{
				Thread.sleep(1500);
				WebElement senddropdown = driver.findElement(By.name("emailsettings:reportDistOrgGroup"));
				Select send = new Select(senddropdown);
				send.selectByVisibleText("AILA");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Select format
				try{
				Thread.sleep(1500);
				WebElement formatdropdown = driver.findElement(By.name("emailsettings:reportEmailFormat"));
				Select format = new Select(formatdropdown);
				format.selectByVisibleText("PDF");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Save the data
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("save_reportconfig")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				
				//XLS Format
				//Click on Add
				try{
				Thread.sleep(1500);
				driver.findElement(By.cssSelector("span.icon-plus")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Select organization
				try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.name("organisation"));
				Select org = new Select(orgdropdown);
				org.selectByVisibleText("TEST");
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
				//Auto Generate
				try{
				Thread.sleep(1500);
				WebElement generatedropdown = driver.findElement(By.name("reportFrequency"));
				Select generate = new Select(generatedropdown);
				generate.selectByVisibleText("Weekly");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Check the checkbox for Enable delivery report by e-mail
				try{
				Thread.sleep(1500);
				driver.findElement(By.xpath("//input[@id='overrideAuth']")).click();
				}catch(Exception e)
				{
					System.out.println(e);
				}
							
				//Select sending to
				try{
				Thread.sleep(1500);
				WebElement senddropdown = driver.findElement(By.name("emailsettings:reportDistOrgGroup"));
				Select send = new Select(senddropdown);
				send.selectByVisibleText("AILA");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Select format
				try{
				Thread.sleep(1500);
				WebElement formatdropdown = driver.findElement(By.name("emailsettings:reportEmailFormat"));
				Select format = new Select(formatdropdown);
				format.selectByVisibleText("XLS");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Save the data
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("save_reportconfig")).click();
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
