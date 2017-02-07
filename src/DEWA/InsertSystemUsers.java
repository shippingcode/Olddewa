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

public class InsertSystemUsers {
	boolean test = false;
	String[] firstname={"AA", "BB", "CC", "DD", "EE", "LL"};
	String surname[]={"FF", "GG", "HH", "II", "JJ", "KK"};
	String username[]={"AAFF", "BBGG", "CCHH", "DDII", "EEJJ", "LLKK"};
	String phonenumber[]={"0732651273", "068234632", "71373467364", "824686234", "87243274", "3456345678"};
	String emailprimary[]={"aila.bogasieru@gmail.com", "abogasieru@gmail.com", "aa@yahoo.com", "ana@yahoo.com","aila.bogasieru@yahoo.com", "aba@yahoo.com"};
	String licensenumber[]={"12424324", "14234324", "24234324", "2434234", "14324324", "23456744"};
	String vehicletype[]={"car", "bike", "motocycle", "bike", "car", "car"};
	

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
		//Choose organisation DEWA
		try{
		Thread.sleep(1500);
		WebElement orgdropdown = driver.findElement(By.name("organisation"));
		Select org = new Select(orgdropdown);
		org.selectByVisibleText("TEST");
		}catch(Exception e)
		{
		System.out.println(e);
		}

		int i=0;
		int j=0;
		int k =0;
		int m =0;
		int n =0;
		int o =0;
		int p =0;
		while (i<=5)
			while (j<=5)
				while(k<=5)
					while(m<=5)
						while(n<=5)
							while (o<=5)
								while(p<=5){
									{
										{
											{
												{
													{
														{
															{
	//Go to Settings -> Add user system
	driver.findElement(By.cssSelector("span.icon-cog")).click();
	driver.findElement(By.linkText("My profile")).isDisplayed();
	driver.findElement(By.linkText("System Users")).isDisplayed();
	//Go to User System
	try{
	Thread.sleep(1500);
	driver.findElement(By.linkText("System Users")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Click on Add System User
	
	try{
	Thread.sleep(1500);
	driver.findElement(By.id("actionsMenu")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	try{
	Thread.sleep(1500);
	driver.findElement(By.linkText("Add")).click();
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill First Name
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("firstName")).sendKeys((firstname[i]));
	}catch(Exception e)
	{
	System.out.println(e);
	}
	//Fill Last name
	try{
	Thread.sleep(1500);
	driver.findElement(By.name("surname")).sendKeys((surname[j]));
	}catch(Exception e)
	{
	System.out.println(e);
			}
	//Fill username
		try{
			Thread.sleep(1500);
		driver.findElement(By.name("userName")).sendKeys((username[k]));
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Choose Role
		try{
			Thread.sleep(1500);
		WebElement userdropdown = driver.findElement(By.name("userLevel"));
	    Select user = new Select(userdropdown);
	   user.selectByVisibleText("Admin");
		}catch(Exception e)
		{
			System.out.println(e);
			}
	   //Choose organization
		try{
			Thread.sleep(1500);
	   //WebElement orgdropdown =  driver.findElement(By.cssSelector("div.col-md-6 > select[name='organisation']"));
	   WebElement orgdropdown =  driver.findElement(By.id("organisationUserSysId"));
	  Select org = new Select(orgdropdown);
	  org.selectByVisibleText("TEST");
		}catch(Exception e)
		{
			System.out.println(e);
			}

	    //Fill phone number
		try{
			Thread.sleep(1500);
	    driver.findElement(By.name("phoneNumber")).sendKeys((phonenumber[m]));
		}catch(Exception e)
		{
			System.out.println(e);
			}
	    //Fill email
		try{
			Thread.sleep(1500);
	    driver.findElement(By.name("emailPrimary")).sendKeys((emailprimary[n]));
		}catch(Exception e)
		{
			System.out.println(e);
			}
		try{
			Thread.sleep(1500);
	    driver.findElement(By.name("licenseNumber")).sendKeys((licensenumber[o]));
		}catch(Exception e)
		{
			System.out.println(e);
			}
		//Fill vehicle type
		try{
			Thread.sleep(1500);
		driver.findElement(By.name("vehicleType")).sendKeys((vehicletype[p]));
		}catch(Exception e)
		{
			System.out.println(e);
			}

		//Press Save Button
		try{
			Thread.sleep(1500);
		driver.findElement(By.id("save_assignment")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		i++;
		j++;
		k++;
		m++;
		n++;
		o++;
		p++;

			}
		}
  }
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
		  }
									}
								}
  }
}



