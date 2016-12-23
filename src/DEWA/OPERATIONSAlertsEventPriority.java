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
import org.testng.annotations.Test;

public class OPERATIONSAlertsEventPriority {
    WebDriver driver = null;
	boolean test, test1, test2, test3 = false;
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
   // WebDriver driver = new FirefoxDriver();
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
	//Go to OPERATIONS Tab
	driver.findElement(By.id("topmenu_maintenance")).click();
	driver.findElement(By.linkText("Maintenance")).isDisplayed();
	driver.findElement(By.linkText("Alerts")).isDisplayed();

	//Go to Alerts
	try{
	Thread.sleep(1500);
	WebElement menu = driver.findElement(By.linkText("Alerts"));
	Actions actions = new Actions(driver);
	actions.moveToElement(menu).perform();
	driver.findElement(By.linkText("Event Priority")).click();
	}catch(Exception e)
	{
		System.out.println(e);
	}

WebElement table_element = driver.findElement(By.className("content tab-content bg-dot50"));
java.util.List<WebElement> tr_collection=table_element.findElements(By.xpath("id('id43')/tbody/tr"));

System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
int row_num,col_num;
row_num=1;
for(WebElement trElement : tr_collection)
{
	java.util.List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
    System.out.println("NUMBER OF COLUMNS="+td_collection.size());
    col_num=1;
    for(WebElement tdElement : td_collection)
    {
        System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
        col_num++;
    }
    row_num++;
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


