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

public class RemoveSLAProfile {

  WebDriver driver = null;
	boolean test = false;
	String profile = GenerateData.generateRandomString(7);
	String contract = GenerateData.generateRandomNumber(5);
	
	
@Test
public void searchandremoveSLAProfile() throws FileNotFoundException {
	//Login
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
	  try{
	  Thread.sleep(1500);
	  WebElement orgdropdown = driver.findElement(By.name("organisation"));
	  Select org = new Select(orgdropdown);
	  org.selectByVisibleText("TEST");
	  }catch(Exception e)
	  {
		System.out.println(e);
	}
	//Go to OPERATIONS Tab
	driver.findElement(By.id("operations")).click();
	driver.findElement(By.linkText("Maintenance")).isDisplayed();
	driver.findElement(By.linkText("Alerts")).isDisplayed();

	//Go to Alerts
	try{ 
	Thread.sleep(1500);
	WebElement menu = driver.findElement(By.linkText("Alerts"));
	Actions actions = new Actions(driver);
	actions.moveToElement(menu).perform();
	driver.findElement(By.linkText("SLA Profile")).click();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
	//Click on add
	try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-plus-sign")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill a name
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("slaName")).sendKeys(profile);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Check Monday
	if (!driver.findElement(By.name("coverMonday")).isSelected())
	{
	     driver.findElement(By.name("coverMonday")).click();
	}
	//Select Cover Start hour
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("coverStartTime")).sendKeys("05:00");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Press Done
	try{
	Thread.sleep(1500);
	driver.findElement(By.xpath("//button[@type='button'])[3]")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	driver.findElement(By.name("coverEndTime")).sendKeys("10:00");

	//Press Done
	try{
	Thread.sleep(1500);
	driver.findElement(By.xpath("//button[@type='button'])[3]")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Acknowledge
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("acknowledgeMins")).clear();
	driver.findElement(By.name("acknowledgeMins")).sendKeys("12");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Attendance
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("attendanceMins")).clear();
	driver.findElement(By.name("attendanceMins")).sendKeys("12");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Resolution
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("resolutionMins")).clear();
	driver.findElement(By.name("resolutionMins")).sendKeys("200");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Overdue Hour Penalty
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("overdueHourPenalty")).clear();
	driver.findElement(By.name("overdueHourPenalty")).sendKeys("10");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Choose organization
	try{
	Thread.sleep(1500);
	WebElement orgdropdown = driver.findElement(By.cssSelector("div.input-group > select[name='organisation']"));
	Select org = new Select(orgdropdown);
	org.selectByVisibleText("TEST");
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill contract
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("contractName")).sendKeys(contract);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Press Save Button
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("save_device")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	
	//Find SLA Profile
	 WebElement table = driver.findElement(By.className("content"));

	// Now get all the TR elements from the table
	java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
	// And iterate over them, getting the cells
	for (WebElement row : allRows) {
	java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	for (WebElement cell : cells) {
		do
		{
			driver.findElement(By.className("next paginate_button paginate_button_enabled")).click();
		}
	while(cell.getText()== profile);
		{
try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-remove")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	     }
		}
	}
	}
	
	
	if(driver.getPageSource().contains("Success! The register was removed successfully"))
	{
		test=true;
		System.out.println("SLA was deleted with success");
	}
	else
	{
		System.out.println("Something went wrong");
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
