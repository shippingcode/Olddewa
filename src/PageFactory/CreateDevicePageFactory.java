package PageFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import DEWA.GenerateData;

public class CreateDevicePageFactory {
	String device = GenerateData.generateRandomString(20);
	WebDriver driver;

	@FindBy(id = "topmenu_device")
	WebElement Device;

	@FindBy(linkText = "List")
	WebElement DeviceList;

	@FindBy(name = "organisation")
	WebElement Organisation;

	@FindBy(css = "span.icon-plus")
	WebElement Add;

	@FindBy(className = "modal-dialog")
	WebElement Modal;

	@FindBy(name = "deviceName")
	WebElement DeviceName;

	@FindBy(id = "organisationId")
	WebElement maker;

	@FindBy(id = "equipmentType")
	WebElement model;

	@FindBy(css = "div.col-md-6 > select[name='organisation']")
	WebElement selectOrg;

	@FindBy(name = "userAppliedStatusType")
	WebElement status;

	@FindBy(id = "latitude")
	WebElement latitude;

	@FindBy(id = "longditude")
	WebElement longitude;

	@FindBy(name = "networkAddress")
	WebElement networkAddress;

	@FindBy(name = "offlineThresholdMins")
	WebElement threshold;

	@FindBy(id = "eweAppId")
	WebElement eweAppId;

	@FindBy(name = "smsChargeId")
	WebElement smscharge;

	@FindBy(xpath = "//button[@class='btn btn-success btn-clean']")
	WebElement saveDevice;

	public CreateDevicePageFactory(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Create device
	public WebElement SelectOrganisation(WebElement Organisation) {
		try {
			Thread.sleep(1500);
			WebElement orgdropdown = Organisation;
			Select org = new Select(orgdropdown);
			org.selectByVisibleText("TEST");
		} catch (Exception e) {
			System.out.println(e);
		}
		return Organisation;
	}

	public String CreateDevice(String Devicename)

	{
		// Go to Device->List
		try {
			Thread.sleep(1500);
			Device.click();
			DeviceList.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Press Add
		try {
			Thread.sleep(1500);
			Device.click();
			Add.click();
			// Modal window is displayed & add new device
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Thread.sleep(1500);
			// Check for modal window is displayed
			Modal.isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill a device name
		try {
			Thread.sleep(1500);
			DeviceName.sendKeys(device);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose Make and Model
		try {
			Thread.sleep(1500);
			WebElement makedropdown = maker;
			Select make = new Select(makedropdown);
			make.selectByVisibleText("make123");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			WebElement modeldropdown = model;
			Select model = new Select(modeldropdown);
			model.selectByVisibleText("model123");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose Owner
		try {
			Thread.sleep(1500);
			WebElement orgdropdown = selectOrg;
			Select organisation = new Select(orgdropdown);
			organisation.selectByVisibleText("TEST");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Add status
		try {
			Thread.sleep(1500);
			WebElement statusdropdown = status;
			Select status = new Select(statusdropdown);
			status.selectByVisibleText("Closed");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill Latitude
		try {
			Thread.sleep(1500);
			latitude.sendKeys("44.440391");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill longitude
		try {
			Thread.sleep(1500);
			longitude.sendKeys("26.101965");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill Network address
		try {
			Thread.sleep(1500);
			networkAddress.sendKeys("192.168.100.3");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill Offline & Maintenance interval
		try {
			Thread.sleep(1500);
			threshold.sendKeys("15");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill Ewe App Id
		try {
			Thread.sleep(1500);
			eweAppId.sendKeys("12390");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill Sms Charge Id
		try {
			Thread.sleep(1500);
			smscharge.sendKeys("8901");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Press Save
		try {
			Thread.sleep(1500);
			saveDevice.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (driver.getPageSource().contains("Success! The register was saved/update successfully")) {

			return Devicename;
		} else {
			System.out.println("Something went wrong");

			return Devicename;
		}
	}
}
