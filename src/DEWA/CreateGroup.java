/* Create Group */

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

	public class CreateGroup { 
		boolean test=false;
		String group = GenerateData.generateRandomString(5);
		
		@Test
		 public void creategroup() throws FileNotFoundException {
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
				
				//Go to RFID CARDS
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("rfid")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Go to Groups sub-menu
				try{
				Thread.sleep(1500);
				driver.findElement(By.linkText("Groups")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Add group
				try{
				Thread.sleep(1500);
				driver.findElement(By.cssSelector("span.icon-plus")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Fill Name
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("groupName")).sendKeys(group);
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Choose organization
				try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.cssSelector("div.uniform > select[name='organisation']"));
				Select org = new Select(orgdropdown);
				org.selectByVisibleText("TEST");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Check the checkbox Open Clearing House
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("ochRoamingEnabled")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
									
				//Save
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("save_parentTokenGroup")).click();
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
				test = true;
		}
		  
  }
