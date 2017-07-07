package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import DEWA.GenerateData;

public class CreateDevicePage {

	WebDriver driver;
	GenerateData genData = null;
	String device = GenerateData.generateRandomString(20);

	By Device = By.id("topmenu_device");
	By DeviceList = By.linkText("List");
	By Organisation = By.name("organisation");
	By Add = By.cssSelector("span.icon-plus");
	By Modal = By.className("modal-dialog");
	By DeviceName = By.name("deviceName");
	By maker = By.id("organisationId");
	By model = By.id("equipmentType");
	By selectOrg = By.cssSelector("div.col-md-6 > select[name='organisation']");
	By status = By.name("userAppliedStatusType");
	By latitude = By.id("latitude");
	By longitude = By.id("longditude");
	By networkaddress = By.name("networkAddress");
	By threshold = By.name("offlineThresholdMins");
	By eweAppId = By.id("eweAppId");
	By smscharge = By.name("smsChargeId");
	By saveDevice = By.xpath("//button[@class='btn btn-success btn-clean']");

	public CreateDevicePage(WebDriver driver) {

		this.driver = driver;

	}

	// Create device
	public WebElement SelectOrganisation(WebElement Organisation) {
		try {
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement((By) Organisation);
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
			driver.findElement(Device).click();
			driver.findElement(DeviceList).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Press Add
		try {
			Thread.sleep(1500);
			driver.findElement(Add).click();
		} catch (Exception e) {
			System.out.println(e);
		}
		// Modal window is displayed & add new device

		// Check for modal window is displayed
		try {
			Thread.sleep(1500);
			driver.findElement(Modal).isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill a device name
		try {
			Thread.sleep(1500);
			driver.findElement(DeviceName).sendKeys(device);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose Make and Model
		try {
			Thread.sleep(1500);
			WebElement makedropdown = driver.findElement(maker);
			Select make = new Select(makedropdown);
			make.selectByVisibleText("make123");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);
			WebElement modeldropdown = driver.findElement(model);
			Select model = new Select(modeldropdown);
			model.selectByVisibleText("model123");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Choose Owner
		try {
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(selectOrg);
			Select organisation = new Select(orgdropdown);
			organisation.selectByVisibleText("TEST");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Add status
		try {
			Thread.sleep(1500);
			WebElement statusdropdown = driver.findElement(status);
			Select status = new Select(statusdropdown);
			status.selectByVisibleText("Closed");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill Latitude
		try {
			Thread.sleep(1500);
			driver.findElement(latitude).sendKeys("44.440391");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill longitude
		try {
			Thread.sleep(1500);
			driver.findElement(longitude).sendKeys("26.101965");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill Network address
		try {
			Thread.sleep(1500);
			driver.findElement(networkaddress).sendKeys("192.168.100.3");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill Offline & Maintenance interval
		try {
			Thread.sleep(1500);
			driver.findElement(threshold).sendKeys("15");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Fill Ewe App Id
		try {
			Thread.sleep(1500);
			driver.findElement(eweAppId).sendKeys("12390");
		} catch (Exception e) {
			System.out.println(e);
		}
		// Fill Sms Charge Id
		try {
			Thread.sleep(1500);
			driver.findElement(smscharge).sendKeys("8901");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Press Save
		try {
			Thread.sleep(1500);
			driver.findElement(saveDevice).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		if (driver.getPageSource().contains("Success! The register was saved/update successfully")) {

			return Devicename;
		} else {
			System.out.println("Something went wrong");

		}
		return Devicename;
	}
}