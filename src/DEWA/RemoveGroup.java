
package DEWA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RemoveGroup { 

boolean test=false;
		String group = GenerateData.generateRandomString(5);
		
		@Test
		 public void editandsavegroup() throws FileNotFoundException {
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
													
				//Save
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("save_parentTokenGroup")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Check the user is displayed
				//Scroll down
		
				//Search the group 
			     WebElement table1 = driver.findElement(By.xpath("//form[starts-with(@id, 'id')]"));
				// Now get all the TR elements from the table
			    java.util.List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
				//And iterate over them, getting the cells
				for (WebElement row1 : allRows1) {
				java.util.List<WebElement> cells1 = row1.findElements(By.tagName("td"));
			    for (WebElement cell : cells1) {
				do{
					driver.findElement(By.className("next paginate_button paginate_button_enabled")).click();
					} while(cell.getText()== group);
							
		     	try{
				Thread.sleep(1500);
				driver.findElement(By.cssSelector("span.icon-trash")).click();
		     	}catch(Exception e)
				{
				System.out.println(e);
				 }
		     	
			      }
			    }
				 if(driver.getPageSource().contains("Success! The register was removed successfully"))
				    {
				    	test = true;
				    	System.out.println ("Group was deleted with success");
				    	
				      }
				    else
				    {
				    	System.out.println ("Something went wrong");
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
