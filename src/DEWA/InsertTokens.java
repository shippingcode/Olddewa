package DEWA;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class InsertTokens {
	String[] tokenA = new String[]{"token1","token2","token3","tken4","token5", "token6"};
	String[] infoA = new String[]{"info1","info2","info3","info4","info5", "info6"};
	boolean test = false;
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
			//Choose organisation DEWA
			try{
				Thread.sleep(1500);
				WebElement orgdropdown = driver.findElement(By.name("organisation"));
				Select org = new Select(orgdropdown);
				 org.selectByVisibleText("DEWA");
			}catch(Exception e)
			{
				System.out.println(e);
			}

		int i=0;
		int j=0;
		while (i<=5)
			while (j<=5)
			{
				{
				//Go to RFID CARDS
				try{
					Thread.sleep(1500);
				driver.findElement(By.id("rfid")).click();
				driver.findElement(By.linkText("RFID Cards Overview")).click();
				}catch(Exception e)
				{
					System.out.println(e);
					}
				//Click on Add
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("actAddCard")).click();
				}catch(Exception e)
				{
					System.out.println(e);
				}
		//Verify the modal is displayed
		driver.findElement(By.className("modal-content")).isDisplayed();
		//Choose type
		try{
			Thread.sleep(1500);
		WebElement carddropdown = driver.findElement(By.name("type"));
	    Select card = new Select(carddropdown);
	    card.selectByVisibleText("PHONE-NUM");
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Fill token
	    driver.findElement(By.name("token")).sendKeys((tokenA[i]));
	    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	    //Fill token info
	    driver.findElement(By.name("info")).sendKeys((infoA[j]));
	    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

	    //Add Expiry date
	    DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	    Calendar c = Calendar.getInstance();
		c.setTime(new Date(0));
		c.add(Calendar.DAY_OF_MONTH, 2441);
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("expiryDate")).sendKeys((dateFormat.format(c.getTime())));

		}catch(Exception e)
		{
			System.out.println(e);

		}
	    //Choose organization
		WebElement orgdropdown = driver.findElement(By.name("creatorOrganisation"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select organisation = new Select(orgdropdown);
		organisation.selectByVisibleText("DEWA");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Choose an user from dropdown list
		WebElement userdropdown = driver.findElement(By.name("user"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select user = new Select(userdropdown);
		user.selectByVisibleText("11");
		//Check the checkbox for OCHP Enabled
		try{
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='ochpEnabled']")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Choose OCHP Type
		WebElement ochpdropdown = driver.findElement(By.name("ochpType"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select ochp = new Select(ochpdropdown);
		ochp.selectByVisibleText("rfid");
        //Choose OCHP Subtype
		WebElement ochpsubtypedropdown = driver.findElement(By.name("ochpSubtype"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select ochpsubtype = new Select(ochpsubtypedropdown);
		ochpsubtype.selectByVisibleText("calypso");
		//Choose OCHP Representation
		WebElement ochprepresdropdown = driver.findElement(By.name("ochpTokenRepresentation"));
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select ochprepres = new Select(ochprepresdropdown);
		ochprepres.selectByVisibleText("sha-160");
		//Fill Contract ID
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("ochpContractId")).sendKeys("3464565");
		}catch(Exception e)
		{
		System.out.println(e);
		}

	    //Save all the info
	    try{
			Thread.sleep(1500);
		driver.findElement(By.id("save_eventrecord")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
	    //Verify is success message is displayed
	    try{
			Thread.sleep(1500);
	    driver.findElement(By.id("successAlert")).isDisplayed();
	    }catch(Exception e)
		{
			System.out.println(e);
			}
	    i++;
	    j++;
				}
			}
		int k = 0;
		 while (k<=5) {
	    //Search the token already created
	    driver.findElement(By.id("search2")).sendKeys(prop.getProperty(tokenA[i]));
	    //Press Search button
	    try{
			Thread.sleep(1500);
	    driver.findElement(By.id("btnSearch")).click();
	    }catch(Exception e)
		{
			System.out.println(e);
			}
	   	//Go to Unassigned Tab
	    try{
			Thread.sleep(1500);
	    driver.findElement(By.name("tab_stock")).isDisplayed();
	    driver.findElement(By.name("tab_stock")).click();
	    }catch(Exception e)
		{
			System.out.println(e);
			}
	    k++;
		 }

	    //Remove the token created

		 int l=0;
		 while (l<=5)
		 {
		//Go to Actions
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("actionsMenu")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		//Remove the token created
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("actDeleteUser")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
	    //Check if the modal is displayed
	    driver.findElement(By.className("modal-content")).isDisplayed();
	    //Actual remove the token
	    try{
	    	Thread.sleep(1500);
	    driver.findElement(By.id("id7d")).click();
	    }catch(Exception e)
		{
			System.out.println(e);
		}

	    //Check that the token is really deleted
	    //Search the token already created
	    driver.findElement(By.id("search2")).sendKeys("token02");
	    //Press Search button
	    try{
			Thread.sleep(1500);
	    driver.findElement(By.id("btnSearch")).click();
	    }catch(Exception e)
		{
			System.out.println(e);
			}
	   	//Go to Unassigned Tab
	    try{
			Thread.sleep(1500);
	    driver.findElement(By.name("tab_stock")).isDisplayed();
	    driver.findElement(By.name("tab_stock")).click();
	    }catch(Exception e)
		{
			System.out.println(e);
			}

	    //Go to Deleted/Unassigned
	    try{
			Thread.sleep(1500);
	    driver.findElement(By.name("tab_dead")).isDisplayed();
	    driver.findElement(By.name("tab_dead")).click();
	    }catch(Exception e)
		{
			System.out.println(e);
			}
	    l++;
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


