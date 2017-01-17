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

public class InsertAlertsContentProfile {
	String[] name = new String[]{"Name1","Name2","Name3","Name4","Name5","Name6","Name7","Name8",
 			"Name9","Name10","Name11","Name12","Name13","Name14","Name15","Name16","Name17",
 			"Name18","Name19","Name20","Name21"};
	String[] subject = new String[]{"subject1","subject2","subject3","subject4","subject5","subject6","subject7","subject8",
 			"subject9","subject10","subject11","subject12","subject13","subject14","subject15","subject16","subject17",
 			"subject18","subject19","subject20","subject21"};
	String[] subject1 = new String[]{"subject11","subject12","subject13","subject14","subject15","subject16","subject17","subject18",
 			"subject19","subject110","subject111","subject112","subject113","subject114","subject115","subject116","subject117",
 			"subject118","subject119","subject120","subject121"};
	String[] emailbody = new String[]{"emailbody1","emailbody2","emailbody3","emailbody4","emailbody5","emailbody6","emailbody7","emailbody8",
 			"emailbody9","emailbody10","emailbody11","emailbody12","emailbody13","emailbody14","emailbody15","emailbody16","emailbody17",
 			"emailbody18","emailbody19","emailbody20","emailbody21"};
	String[] emailbody1 = new String[]{"emailbody11","emailbody12","emailbody13","emailbody14","emailbody15","emailbody16","emailbody17","emailbody18",
 			"emailbody19","emailbody110","emailbody111","emailbody112","emailbody113","emailbody114","emailbody115","emailbody116","emailbody117",
 			"emailbody118","emailbody119","emailbody120","emailbody121"};
	String[] phone = new String[]{"phone1","phone2","phone3","phone4","phone5","phone6","phone7","phone8",
 			"phone9","phone10","phone11","phone12","phone13","phone14","phone15","phone16","phone17",
 			"phone18","phone19","phone20","phone21"};
	String[] phone1 = new String[]{"phone11","phone12","phone13","phone14","phone15","phone16","phone17","phone18",
 			"phone19","phone110","phone111","phone112","phone113","phone114","phone115","phone116","phone117",
 			"phone118","phone119","phone120","phone121"};
	String[] sms = new String[]{"sms1","sms2","sms3","sms4","sms5","sms6","sms7","sms8",
 			"sms9","sms10","sms11","sms12","sms13","sms14","sms15","sms16","sms17",
 			"sms18","sms19","sms20","sms21"};
	String[] sms1 = new String[]{"sms11","sms12","sms13","sms14","sms15","sms16","sms17","sms18",
 			"sms19","sms110","sms111","sms112","sms113","sms114","sms115","sms116","sms117",
 			"sms118","sms119","sms120","sms121"};
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
	try{
	Thread.sleep(1500);
	WebElement orgdropdown = driver.findElement(By.name("organisation"));
	Select org = new Select(orgdropdown);
	org.selectByVisibleText("DEWA");
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
	driver.findElement(By.linkText("Alert Content Profile")).click();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	int i,k,l,m,n,o,r,s,t;
	for(i=0;i<1000;i++)
		for(k=0;k<1000;k++)
			for(l=0;l<1000;l++)
				for(m=0;m<1000;m++)
				    for(n=0;n<1000;n++)
				        for(o=0;o<1000;o++)
					       for(r=0;r<1000;r++)
						       for(s=0;s<1000;s++)
							       for(t=0;t<1000;t++){
	 {
	     {
                 {
                                                            		                                                            	}
			             	{
					           {
						          {
						        	  {
						        		  {



	//Add alert content profile
	try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-plus")).click();
	//driver.findElement(By.cssSelector("div.side.pull-right > a.widget-icon")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Modal is displayed
	try{
	Thread.sleep(1500);
	driver.findElement(By.className("modal-body clearfix")).isDisplayed();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill name
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("alertContentProfileName")).sendKeys(name[i]);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Choose organisation
	try{
	Thread.sleep(1500);
	WebElement orgdrop = driver.findElement(By.name("ownerOrganisation"));
	Select org = new Select(orgdrop);
	org.selectByVisibleText("DEWA");
	}catch(Exception e)
	{
		System.out.println(e);
	}
	//Fill names
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("emailAlertSubjectText")).sendKeys(subject[k]);

	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("emailClearanceSubjectText")).sendKeys(subject1[l]);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill body text for alert & clearance
	try{
	Thread.sleep(1500);
	//driver.findElement(By.id("emailAlertBodyText")).clear();
	Actions actions1 = new Actions(driver);
	WebElement menu1 = null;
	actions1.moveToElement(menu1).perform();
	driver.findElement(By.id("emailAlertBodyText")).sendKeys(emailbody[m]);
	}catch(Exception e)
	{
	System.out.println(e);
	}

	try{
	Thread.sleep(1500);
	//driver.findElement(By.id("emailClearanceSubjectBodyText")).clear();
	Actions actions2 = new Actions(driver);
	WebElement menu2 = null;
	actions2.moveToElement(menu2).perform();
	driver.findElement(By.id("emailClearanceSubjectBodyText")).sendKeys(emailbody1[n]);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill phone numbers
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("phoneAlertText")).sendKeys(phone[o]);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("phoneClearanceText")).sendKeys(phone1[r]);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("smsAlertText")).sendKeys(sms[s]);
	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("smsClearanceText")).sendKeys(sms1[t]);
	}catch(Exception e)
	{
	System.out.println(e);
	}

	try{
	Thread.sleep(1500);
	driver.findElement(By.id("save_device")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
     	}
			}
	          }
				}
					}
				       }
						  }
							 }
	int j;
	for (j=0;j<1000;j++) {

	}
	//Remove the content alert
	try{
	Thread.sleep(1500);
	driver.findElement(By.cssSelector("span.icon-trash")).click();
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
	
       }

          }

