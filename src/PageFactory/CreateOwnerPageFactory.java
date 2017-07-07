package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import DEWA.GenerateData;

public class CreateOwnerPageFactory {
	String owner = GenerateData.generateRandomString(20);
	WebDriver driver;

	@FindBy(css = "span.icon-link")
	WebElement Owner;

	@FindBy(linkText = "Add")
	WebElement AddOwner;

	@FindBy(className = "modal-dialog")
	WebElement ModalDialog;

	@FindBy(name = "organisationName")
	WebElement OrganisationName;

	@FindBy(className = "alertContentProfile")
	WebElement Alert;

	@FindBy(name = "license")
	WebElement license;

	@FindBy(name = "timezone")
	WebElement timezone;

	@FindBy(name = "languageDCC")
	WebElement Language;

	@FindBy(name = "localeDDC")
	WebElement Locale;

	@FindBy(xpath = "//input[@name='ochpEnabled']")
	WebElement OCHP;

	@FindBy(id = "overrideAuth")
	WebElement Auth;

	@FindBy(name = "ochpOperatorId")
	WebElement OCHPoperator;

	@FindBy(name = "save_owner")
	WebElement saveOwner;

	public CreateOwnerPageFactory(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

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

	public String CreateOwner(String ownername) {

		// Go on Organization
		try {
			Thread.sleep(1500);
			Owner.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Click on Add new owner
		try {
			Thread.sleep(1500);
			AddOwner.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Modal window is displayed & add new owner
		try {
			Thread.sleep(1500);
			// Check for modal window is displayed
			ModalDialog.isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill an owner name
		try {
			Thread.sleep(1500);
			OrganisationName.sendKeys(owner);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Choose alarm
		try {
			Thread.sleep(1500);
			WebElement alarmdropdown = Alert;
			Select alarm = new Select(alarmdropdown);
			alarm.selectByVisibleText("alert1");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Choose license
		try {
			Thread.sleep(1500);
			WebElement licensedrop = license;
			Select license = new Select(licensedrop);
			license.selectByVisibleText("Default");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose time zone
		try {
			Thread.sleep(1500);
			WebElement timezonedropdown = timezone;
			Select timezone = new Select(timezonedropdown);
			timezone.selectByVisibleText("Europe/Bucharest");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose language
		try {
			Thread.sleep(1500);
			WebElement langdropdown = Language;
			Select lang = new Select(langdropdown);
			lang.selectByVisibleText("ENGLISH");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose locale
		try {
			Thread.sleep(1500);
			WebElement localedropdown = Locale;
			Select locale = new Select(localedropdown);
			locale.selectByVisibleText("UNITED KINGDOM");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Check radio button ochpEnabled
		try {
			Thread.sleep(1500);
			OCHP.click();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			Auth.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Add Operator Id
		try {
			Thread.sleep(1500);
			OCHPoperator.sendKeys("99");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Press Save Button
		try {
			Thread.sleep(1500);
			saveOwner.click();
		} catch (Exception e) {
			System.out.println(e);
		}
		if (driver.getPageSource().contains("Success! The register was saved/update successfully")) {

			System.out.println("Owner was created with success");
		} else {
			System.out.println("Something went wrong");
		}
		return ownername;
	}
}
