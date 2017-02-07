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
    import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

	public class RemoveScheduledReports {
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
		      //Create Chrome drive
		      //System.setProperty("webdriver.chrome.driver", "C://Users/Aila/Downloads/chromedriver.exe");
		      //WebDriver driver = new ChromeDriver();
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
				
				//Go to  REPORTS Tab
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("reports")).click();
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
				//Remove reports containing AILA as user
				
				if(driver.getPageSource().contains("AILA"))
					{
					try{
					Thread.sleep(1500);
					driver.findElement(By.cssSelector("span.icon-trash")).click();
					}catch(Exception e)
					{
					System.out.println(e);
					  }
					}
					
		}
	}
