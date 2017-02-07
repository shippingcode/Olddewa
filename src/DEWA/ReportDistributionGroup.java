/* Create Distribution Group */
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

  public class ReportDistributionGroup  {
  	boolean test=false;
  	String distributiongroup = GenerateData.generateRandomAlphaNumeric(5);
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
  	       //System.setProperty("webdriver.chrome.driver", "C://Users/Aila/Downloads/chromedriver.exe");
           //WebDriver driver = new ChromeDriver();
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
  			driver.findElement(By.linkText("Distribution Group")).click();
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
  			//Select organization
  			try{
  			Thread.sleep(1500);
  			WebElement orgdropdown = driver.findElement(By.cssSelector("div.col-md-12 > select[name='organisation']"));
  			Select org = new Select(orgdropdown);
  			org.selectByVisibleText("TEST");
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			//Fill a name
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.name("reportDistOrgGroupName")).sendKeys(distributiongroup);
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			//Select user
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.name("user")).sendKeys("test.admin");
  			WebElement userdropdown = driver.findElement(By.name("user"));
  			Select user = new Select(userdropdown);
  			user.selectByVisibleText("dewa.admin");
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			//Fill address email
  			try{
  	  		Thread.sleep(1500);
  	  		driver.findElement(By.cssSelector("starts-with[@id='tags1485529815']")).sendKeys("aila.bogasieru@gmail.com");
  	  		}catch(Exception e)
  	  		{
  	  		System.out.println(e);
  	  		}
  			
  			//Save the data
  			try{
  			Thread.sleep(1500);
  			driver.findElement(By.name("save_reportDistOrgGroup")).click();
  			}catch(Exception e)
  			{
  			System.out.println(e);
  			}
  			
  			/* Remove report created
  			try{
  	  		Thread.sleep(1500);
  	  		driver.findElement(By.cssSelector("span.icon-trash")).click();
  	  		}catch(Exception e)
  	  		{
  	  		System.out.println(e);
  	  		}
  			
  			*/
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
