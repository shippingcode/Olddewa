package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import DEWA.GenerateData;

public class CreateOwnerPage {

	WebDriver driver;
	GenerateData genData = null;
	String owner = GenerateData.generateRandomString(20);
	WebElement OrganisationName = null;

	By Owner = By.cssSelector("span.icon-link");
	By Add = By.linkText("Add");
	By Modal = By.className("modal-dialog");
	By OwnerName = By.name("organisationName");
	By Alert = By.className("alertContentProfile");
	By license = By.name("license");
	By timezone = By.name("timezone");
	By language = By.name("languageDCC");
	By locale = By.name("localeDDC");
	By Ochp = By.xpath("//input[@name='ochpEnabled']");
	By Auth = By.id("overrideAuth");
	By OCHPoperator = By.name("ochpOperatorId");
	By saveOwner = By.name("save_owner");

	public CreateOwnerPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement SelectOrganisation(WebElement OrganisationName) {
		try {
			Thread.sleep(1500);
			WebElement orgdropdown = OrganisationName;
			Select org = new Select(orgdropdown);
			org.selectByVisibleText("TEST");
		} catch (Exception e) {
			System.out.println(e);
		}
		return OrganisationName;
	}

	public String createOwner(String ownername) {
		// Go on Organization
		try {
			Thread.sleep(1500);
			driver.findElement(Owner).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Click on Add new owner
		try {
			Thread.sleep(1500);
			driver.findElement(Add).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Modal window is displayed & add new owner
		try {
			Thread.sleep(1500);
			// Check for modal window is displayed
			driver.findElement(Modal).isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill an owner name
		try {
			Thread.sleep(1500);
			driver.findElement(OwnerName).sendKeys(owner);
		} catch (Exception e) {
			System.out.println(e);
		}
			
		// Choose time zone
		try {
			Thread.sleep(1500);
			WebElement timezonedropdown = driver.findElement(timezone);
			Select timezone = new Select(timezonedropdown);
			timezone.selectByVisibleText("Europe/Bucharest");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose language
		try {
			Thread.sleep(1500);
			WebElement langdropdown = driver.findElement(language);
			Select lang = new Select(langdropdown);
			lang.selectByVisibleText("ENGLISH");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose locale
		try {
			Thread.sleep(1500);
			WebElement localedropdown = driver.findElement(locale);
			Select locale = new Select(localedropdown);
			locale.selectByVisibleText("UNITED KINGDOM");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Check radio button ochpEnabled
		try {
			Thread.sleep(1500);
			driver.findElement(Ochp).click();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			driver.findElement(Auth).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Add Operator Id
		try {
			Thread.sleep(1500);
			driver.findElement(OCHPoperator).sendKeys("99");
		} catch (Exception e) {
			System.out.println(e);
		}
		return ownername;
	}
		public void saveOwner(String ownername){
		// Press Save Button
		try {
			Thread.sleep(1500);
			driver.findElement(saveOwner).click();
		} catch (Exception e) {
			System.out.println(e);
		 }
		}
		public void checkOwner_success(){
		if (driver.getPageSource().contains("Success! The register was saved/update successfully")) {

			System.out.println("Owner was created with success");
		} else {
			System.out.println("Something went wrong");
		}
		
	}
		public void CreateOwner(String ownername){
			this.SelectOrganisation(OrganisationName);
			this.createOwner(ownername);
			this.saveOwner(ownername);
			this.checkOwner_success();
 }
}
