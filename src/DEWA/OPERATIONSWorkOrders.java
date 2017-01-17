package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class OPERATIONSWorkOrders {
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
		//Go to OPERATIONS Tab
		driver.findElement(By.id("topmenu_maintenance")).click();
		driver.findElement(By.linkText("Maintenance")).isDisplayed();
		driver.findElement(By.linkText("Work Orders")).isDisplayed();
		//Go to Work orders
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("Work Orders")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}

		//Choose My work order
		try{
		Thread.sleep(1500);
		WebElement myworkdrop = driver.findElement(By.name("search2"));
	    Select mywork = new Select(myworkdrop);
		mywork.selectByVisibleText("My work order");
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Press Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("searchBtn"));
	     }catch(Exception e)
		{
		System.out.println(e);
		}

		//Choose All work order
		try{
		Thread.sleep(1500);
		WebElement workdrop = driver.findElement(By.name("search2"));
	    Select work = new Select(workdrop);
		work.selectByVisibleText("All work order");
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Press Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("searchBtn"));
	   	}catch(Exception e)
		{
			System.out.println(e);
			}

		//Click on Actions
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("actionsMenu")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Raise new work order
		driver.findElement(By.linkText("Raise new work order")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Fill an work order title
		driver.findElement(By.name("workOrder.workOrderTitle")).sendKeys("Selenium WorkOrder");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Choose type of work
		WebElement worktype = driver.findElement(By.name("workOrder.workOrderType"));
	    Select type = new Select(worktype);
	    type.selectByVisibleText("preventitive");
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	    //Choose event priority
	    WebElement eventdrop = driver.findElement(By.name("workOrder.eventPriority"));
	    Select event = new Select(eventdrop);
	    event.selectByVisibleText("Parked fault");
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	//Choose device
	    driver.findElement(By.name("deviceSelect")).sendKeys("device");
	    WebElement devicedrop = driver.findElement(By.name("deviceSelect"));
	    Select device = new Select(devicedrop);
	    Actions actions = new Actions(driver);
		actions.moveToElement(devicedrop).perform();
		device.selectByVisibleText("device1");
		driver.findElement(By.linkText("device1")).click();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	    //Choose organisation
	    WebElement orgdrop = driver.findElement(By.id("organisationId"));
	    Select org = new Select(orgdrop);
	    org.selectByVisibleText("TEST");
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	    //Press Save
	    driver.findElement(By.name("save")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Choose All Unassigned Work Orders
		try{
		Thread.sleep(1500);
		WebElement workdrop = driver.findElement(By.name("search2"));
		Select work = new Select(workdrop);
		work.selectByVisibleText("All Unassigned Work Orders");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Press Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("searchBtn"));
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Choose Unassigned Organisations Work Orders
		try{
		Thread.sleep(1500);
		WebElement workdrop = driver.findElement(By.name("search2"));
		Select work = new Select(workdrop);
		work.selectByVisibleText("Unassigned Organisations Work Orders");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Press Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("searchBtn"));
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Choose View All Work Order Upcoming In Next 15 Days
		try{
		Thread.sleep(1500);
		WebElement workdrop15 = driver.findElement(By.name("search2"));
		Select work15 = new Select(workdrop15);
		work15.selectByVisibleText("View All Work Order Upcoming In Next 15 Days");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Press Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("searchBtn"));
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Choose View All Work Order Upcoming In Next 30 Days
		try{
		Thread.sleep(1500);
		WebElement workdrop30 = driver.findElement(By.name("search2"));
		Select work30 = new Select(workdrop30);
		work30.selectByVisibleText("View All Work Order Upcoming In Next 30 Days");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Press Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("searchBtn"));
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Choose View All Work Order Upcoming In Next 60 Days
		try{
		Thread.sleep(1500);
		WebElement workdrop60 = driver.findElement(By.name("search2"));
		Select work60 = new Select(workdrop60);
		work60.selectByVisibleText("View All Work Order Upcoming In Next 60 Days");
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Press Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("searchBtn"));
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Choose All work order
		try{
			Thread.sleep(1500);
		WebElement workdrop = driver.findElement(By.name("search2"));
	    Select work = new Select(workdrop);
		work.selectByVisibleText("All work order");
		}catch(Exception e)
		{
			System.out.println(e);
		}

		//Press Search
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("searchBtn"));
	   	}catch(Exception e)
		{
			System.out.println(e);
		}

	  WebElement table = driver.findElement(By.id("DataTables_Table_0_wrapper"));

	  // Now get all the TR elements from the table
	  java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
	 // And iterate over them, getting the cells
	 for (WebElement row : allRows) {
	 java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
	 for (WebElement cell : cells) {
	   while(cell.getText()== "work1");
	  	   try{
		   Thread.sleep(1500);
		    //When is found the org delete it
		    driver.findElement(By.cssSelector("span.icon-cogs")).click();
		    }catch(Exception e)
		   	{
		    System.out.println(e);
		         }
	        }
	 try{
	Thread.sleep(1500);
	driver.findElement(By.id("close_modal_edit"));
	}catch(Exception e)
	{
	System.out.println(e);
	}
	    }
		//Logout
		try{
		driver.findElement(By.className("icon-eject")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		test=true;

	}




}







