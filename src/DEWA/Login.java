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

  public class Login {
	boolean test=false;
	WebDriver driver = null;
		
		@Test
		 public void login() throws FileNotFoundException {
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
		  }
						
	  
			
		  }

