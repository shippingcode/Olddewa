/* Add motorist */

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

	public class RFIDCARDS_Motorist { 
		boolean test=false;
		String motorist = GenerateData.generateRandomString(5);
		String phone = GenerateData.generateRandomNumber(10);
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
				
				//Go to RFID CARDS
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("rfid")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Go to Motorist sub-menu
				try{
				Thread.sleep(1500);
				driver.findElement(By.linkText("Motorist")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Add motorist
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
				driver.findElement(By.name("userName")).sendKeys(motorist);
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Choose organization
				try{
				Thread.sleep(1500);
				WebElement org1dropdown = driver.findElement(By.id("organisationUserRfid"));
				Select org1 = new Select(org1dropdown);
				org1.selectByVisibleText("TEST");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Choose membership
				try{
				Thread.sleep(1500);
				WebElement memdropdown = driver.findElement(By.name("memType"));
				Select mem = new Select(memdropdown);
				mem.selectByVisibleText("Annual");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Fill phone
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("phoneNumber")).sendKeys(phone);
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				
				//Fill email address
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("emailPrimary")).sendKeys("aila.bogasieru@gmail.com");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				//License no
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("licenseNumber")).sendKeys("21345678934567");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				//Vehicle
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("vehicleType")).sendKeys("car");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				//Save
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("save_assignment")).click();
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
