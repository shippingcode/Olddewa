package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import DEWA.GenerateData;

public class CreateSystemUserPage {

	GenerateData genData = null;
	String device = GenerateData.generateRandomString(20);
	String firstname = GenerateData.generateRandomString(5);
	String surname = GenerateData.generateRandomString(5);
	String username = GenerateData.generateRandomString(5);
	String phone = GenerateData.generateRandomNumber(10);
	WebDriver driver = null;

	By Settings = By.cssSelector("span.icon-cog");
	By SystemUser = By.linkText("System Users");
	By Menu = By.id("actionsMenu");
	By AddUser = By.linkText("Add");
	By FirstName = By.name("firstName");
	By Name = By.name("surname");
	By Username = By.name("userName");
	By Level = By.name("userLevel");
	By TopOrg = By.cssSelector("div.col-md-6 > select[name='organisation']");
	By Phone = By.name("phoneNumber");
	By Email = By.name("emailPrimary");
	By License = By.name("licenseNumber");
	By Vehicle = By.name("vehicleType");
	By Membership = By.name("memType");
	By SaveUser = By.id("save_assignment");
	By SearchUser = By.id("search");
	By SearchButton = By.id("btnSearch");
	By ResetPassword = By.linkText("Reset password");
	By UserReset = By.name("user.userId");
	By ResetButton = By.name("resetPassword");

	public CreateSystemUserPage(WebDriver driver) {

		this.driver = driver;

	}

	public void MenuSystemUser() {
		driver.findElement(Settings).click();
		driver.findElement(SystemUser).click();
		driver.findElement(Menu).click();

	}

	// Create system user

	public String CreateSystemUser(String username) {
		// Fill First Name
		try {
			Thread.sleep(1500);
			driver.findElement(AddUser).click();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			driver.findElement(FirstName).sendKeys(firstname);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			// Fill Last name
			driver.findElement(Name).sendKeys(surname);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			// Fill username
			driver.findElement(Username).sendKeys(username);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Choose Role
		try {
			Thread.sleep(1500);
			WebElement userdropdown = driver.findElement(Level);
			Select user1 = new Select(userdropdown);
			user1.selectByVisibleText("Technician");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose organization
		try {
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(TopOrg);
			Select org = new Select(orgdropdown);
			org.selectByVisibleText("TEST");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill phone number
		try {
			Thread.sleep(1500);
			driver.findElement(Phone).sendKeys(phone);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill email
		try {
			Thread.sleep(1500);
			driver.findElement(Email).sendKeys("abogasieru@yahoo.com");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			driver.findElement(License).sendKeys("123567892");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill vehicle type
		try {
			Thread.sleep(1500);
			driver.findElement(Vehicle).sendKeys("car");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Choose membership
		try {
			Thread.sleep(1500);
			WebElement membershipdropdown = driver.findElement(Membership);
			Select mem = new Select(membershipdropdown);
			mem.selectByVisibleText("Monthly");
		} catch (Exception e) {
			System.out.println(e);
		}
		return username;
	}
		
		public void Save(){
		// Press Save Button
		try {
			Thread.sleep(1500);
			driver.findElement(SaveUser).click();
		} catch (Exception e) {
			System.out.println(e);
		 }
		}
		public String checkUser_success(String username){
		if (driver.getPageSource().contains("Success! The register was saved/update successfully")) {
			return username;

		} else {
			System.out.println("Something went wrong");
		}
		return username;

	}

	// Search the user created earlier
	public String SearchUser(String username) {
		try {
			Thread.sleep(1500);
			driver.findElement(SearchUser).sendKeys(username);
		} catch (Exception e) {
			System.out.println(e);
		}
		return username;
	}
		public void SearchAction(){

		try {
			Thread.sleep(1500);
			driver.findElement(SearchUser).click();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	// Reset password
	public void ResetPassword(String username) {
		try {
			Thread.sleep(1500);
			driver.findElement(ResetPassword).click();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			driver.findElement(UserReset).sendKeys(username);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		public void ResetAction(){
		try {
			Thread.sleep(1500);
			driver.findElement(ResetButton).click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
		public void SystemUser(String username) {
			this.MenuSystemUser();
			this.CreateSystemUser(username);
			this.Save();
			this.checkUser_success(username);
		}
		public void SearchByUser(String username)	{
			this.SearchUser(username);
			this.SearchAction();
		}
		public void ResetPasswordUser(String username){	
			this.ResetPassword(username);
			this.ResetAction();
			
		}
	}


