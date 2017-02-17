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

public class InsertGroups {
	boolean test = false;
	String groupname[] = {GenerateData.generateRandomString(5), GenerateData.generateRandomString(5), GenerateData.generateRandomString(5), GenerateData.generateRandomString(5), GenerateData.generateRandomString(5)};

  @Test
  public void insertgroups() throws FileNotFoundException {
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
		//Go to RFID CARDS -> Groups
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("rfid")).click();
		driver.findElement(By.linkText("Groups")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		}
		int i=0;
		while (i<5)
				{
		//ADD a new group
		try{
		Thread.sleep(1500);
		driver.findElement(By.linkText("Add")).click();
		//span.icon-plus
		}catch(Exception e)
		{
		System.out.println(e);
		}
		try{
		Thread.sleep(1500);
		driver.findElement(By.id("groupName")).sendKeys(groupname[i]);
		WebElement orgdropdown = driver.findElement(By.cssSelector("div.uniform > select[name='organisation']"));
	    Select orgsel = new Select(orgdropdown);
	    orgsel.selectByVisibleText("TEST");
	    //Check the checkbox for Open Clearing House
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
		i++;
				}
		int k=0;
		while (k<5)
		{
		//Find Group created into the table
		 WebElement table = driver.findElement(By.className("table table-bordered table-striped"));

		// Now get all the TR elements from the table
		java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
		java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
		for (WebElement cell : cells) {
		while(cell.getText()== groupname[k]);
		}
       try{
		Thread.sleep(1500);
		//When is found the org delete it
		driver.findElement(By.cssSelector("span.icon-pencil")).click();
		driver.findElement(By.id("groupName")).sendKeys(groupname[k]);
		driver.findElement(By.id("save_parentTokenGroup")).click();
		driver.findElement(By.cssSelector("span.icon-trash")).click();
		}catch(Exception e)
		{
		System.out.println(e);
		 }
		
		k++;
		}

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

