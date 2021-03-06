/* Add RFID CARD with user already assigned */

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

	public class RFIDCARDS_RFIDCardsOverviewAssign { 
		boolean test=false;
		String token, info = GenerateData.generateRandomAlphaNumeric(5);
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
				driver.findElement(By.linkText("RFID Cards Overview")).click();
				}catch(Exception e)
				{
					System.out.println(e);
					}
				//Add RFID CARD
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("actAddCard")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Choose type
				try{
				Thread.sleep(1500);
				WebElement typedropdown = driver.findElement(By.name("type"));
				Select type = new Select(typedropdown);
				type.selectByVisibleText("MIFARE-D");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Fill name & info
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("token")).sendKeys(token);
				driver.findElement(By.name("info")).sendKeys(info);
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				//Choose organization
				try{
				Thread.sleep(1500);
				WebElement org1dropdown = driver.findElement(By.name("creatorOrganisation"));
				Select org1 = new Select(org1dropdown);
				org1.selectByVisibleText("TEST");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				//Select user
				try{
				Thread.sleep(1500);
				WebElement org1dropdown = driver.findElement(By.name("user"));
				Select org1 = new Select(org1dropdown);
				org1.selectByVisibleText("SeleniumMotorist");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				//Check checkbox
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("ochpEnabled")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				//Choose OCHP type
				try{
				Thread.sleep(1500);
				WebElement OCHPtypedropdown = driver.findElement(By.name("ochpType"));
				Select OCHPtype = new Select(OCHPtypedropdown);
				OCHPtype.selectByVisibleText("rfid");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Choose OCHP subtype
				try{
				Thread.sleep(1500);
				WebElement OCHPsubtypedropdown = driver.findElement(By.name("ochpSubtype"));
				Select OCHPsubtype = new Select(OCHPsubtypedropdown);
				OCHPsubtype.selectByVisibleText("calypso");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Choose OCHP representation
				try{
				Thread.sleep(1500);
				WebElement OCHPrepresdropdown = driver.findElement(By.name("ochpTokenRepresentation"));
				Select OCHPrepres = new Select(OCHPrepresdropdown);
				OCHPrepres.selectByVisibleText("plain");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Fill contract ID
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("ochpContractId")).sendKeys("45");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Save
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("save_eventrecord")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
						
				 //Search the token already created
			    driver.findElement(By.id("search2")).sendKeys(token);
			    //Press Search button
			    try{
					Thread.sleep(1500);
			    driver.findElement(By.id("btnSearch")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}

			    //Go to Whitelisted Tab
			    try{
				Thread.sleep(1500);
			    driver.findElement(By.name("tab_white")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}

			    //Bar a token
			    try{
				Thread.sleep(1500);
			    driver.findElement(By.cssSelector("span.icon-ban-circle")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}
			    //Verify if modal window is displayed
			    driver.findElement(By.className("modal-content")).isDisplayed();
			    //Press Bar button
			    try{
					Thread.sleep(1500);
			   	driver.findElement(By.name("bar")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}
			    //Clear the previous search
			    try{
					Thread.sleep(1500);
			    driver.findElement(By.id("search2")).clear();
			    }catch(Exception e)
				{
					System.out.println(e);
					}
			  //Make a search
			    driver.findElement(By.id("search2")).sendKeys(token);
			    //Press Search button
			    try{
				Thread.sleep(1500);
			    driver.findElement(By.id("btnSearch")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}

			    //Go to Blacklisted
			    try{
					Thread.sleep(1500);
			    driver.findElement(By.name("tab_black")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}


			    //Un-bar the token
			    try{
					Thread.sleep(1500);
			    driver.findElement(By.cssSelector("span.icon-ban-circle")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}
			    //Press Un-bar button
			    try{
					Thread.sleep(1500);
			    driver.findElement(By.name("un-bar")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}

			    //Make a search
			    driver.findElement(By.id("search2")).sendKeys(token);
			    //Press Search button
			    try{
					Thread.sleep(1500);
			    driver.findElement(By.id("btnSearch")).click();
			    }catch(Exception e)
				{
					System.out.println(e);
					}

			    //Delete token created
			    try{
			  	Thread.sleep(1500);
			  	driver.findElement(By.id("actionsMenu")).click();
			  	}catch(Exception e)
			  	{
			  	System.out.println(e);
			  	}
			  	//Delete a RFID CARD
			  	try{
			  	Thread.sleep(1500);
			  	driver.findElement(By.id("actDeleteUser")).click();
			  	}catch(Exception e)
			  	{
			  	System.out.println(e);
			  	}
			    //Press Delete button
			    try{
				Thread.sleep(1500);
		    	driver.findElement(By.name("deleteToken")).click();
				}catch(Exception e)
				{
					System.out.println(e);
				}
			  

			    //Make a search
			    driver.findElement(By.id("search2")).sendKeys(token);
			    //Press Search button
			    try{
					Thread.sleep(1500);
			    driver.findElement(By.id("btnSearch")).click();
			    }catch(Exception e)
				{
				System.out.println(e);
				}
  
			    
			    //Go to Deleted
			    try{
				Thread.sleep(1500);
			    driver.findElement(By.name("tab_dead")).click();
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
