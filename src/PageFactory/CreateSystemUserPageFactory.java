package PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import DEWA.GenerateData;

public class CreateSystemUserPageFactory {

	GenerateData genData = null;
	String device = GenerateData.generateRandomString(20);
	String firstname = GenerateData.generateRandomString(5);
	String surname = GenerateData.generateRandomString(5);
	String username = GenerateData.generateRandomString(5);
	String phone = GenerateData.generateRandomNumber(10);
	WebDriver driver = null;

	@FindBy(css = "span.icon-cog")
	WebElement Settings;

	@FindBy(linkText = "System Users")
	WebElement SystemUser;

	@FindBy(id = "actionsMenu")
	WebElement Menu;

	@FindBy(linkText = "Add")
	WebElement AddUser;

	@FindBy(name = "firstName")
	WebElement FirstName;

	@FindBy(name = "surname")
	WebElement Name;

	@FindBy(name = "userName")
	WebElement Username;

	@FindBy(name = "userLevel")
	WebElement Level;

	@FindBy(css = "div.col-md-6 > select[name='organisation']")
	WebElement TopOrg;

	@FindBy(name = "phoneNumber")
	WebElement Phone;

	@FindBy(name = "emailPrimary")
	WebElement Email;

	@FindBy(name = "licenseNumber")
	WebElement License;

	@FindBy(name = "vehicleType")
	WebElement Vehicle;

	@FindBy(name = "memType")
	WebElement Membership;

	@FindBy(id = "save_assignment")
	WebElement SaveUser;

	@FindBy(id = "search")
	WebElement SearchUser;

	@FindBy(id = "btnSearch")
	WebElement SearchButton;

	@FindBy(linkText = "Reset password")
	WebElement ResetPassword;

	@FindBy(name = "user.userId")
	WebElement UserReset;

	@FindBy(name = "resetPassword")
	WebElement ResetButton;
	
	public CreateSystemUserPageFactory(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void MenuSystemUser() {
		Settings.click();
		SystemUser.click();
		Menu.click();

	}

	// Create system user

	public String CreateSystemUser(String username) {
		// Fill First Name
		try {
			Thread.sleep(1500);
			AddUser.click();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			FirstName.sendKeys(firstname);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill Last name
		try {
			Thread.sleep(1500);
			Name.sendKeys(surname);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill username
		try {
			Thread.sleep(1500);
			Username.sendKeys(username);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Choose Role
		try {
			Thread.sleep(1500);
			WebElement userdropdown = Level;
			Select user1 = new Select(userdropdown);
			user1.selectByVisibleText("Technician");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Choose organization
		try {
			Thread.sleep(1500);
			WebElement orgdropdown = TopOrg;
			Select org = new Select(orgdropdown);
			org.selectByVisibleText("TEST");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill phone number
		try {
			Thread.sleep(1500);
			Phone.sendKeys(phone);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill email
		try {
			Thread.sleep(1500);
			Email.sendKeys("abogasieru@yahoo.com");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			License.sendKeys("123567892");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill vehicle type
		try {
			Thread.sleep(1500);
			Vehicle.sendKeys("car");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Choose membership
		try {
			Thread.sleep(1500);
			WebElement membershipdropdown = Membership;
			Select mem = new Select(membershipdropdown);
			mem.selectByVisibleText("Monthly");
		} catch (Exception e) {
			System.out.println(e);
		}
		return username;
	}
		// Press Save Button
		public void Save(){
		try {
			Thread.sleep(1500);
			SaveUser.click();
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
			SearchUser.sendKeys(username);
		} catch (Exception e) {
			System.out.println(e);
		}
		return username;
	}
	public void SearchAction(){

		try {
			Thread.sleep(1500);
			SearchUser.click();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	// Reset password
	public String ResetPassword(String username) {
		try {
			Thread.sleep(1500);
			ResetPassword.click();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			UserReset.sendKeys(username);
		} catch (Exception e) {
			System.out.println(e);
		}
		return username;
	}
		public void ResetAction(){
		try {
			Thread.sleep(1500);
			ResetButton.click();
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
