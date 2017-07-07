package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

	WebDriver driver;

	By logout = By.className("icon-eject");

	public LogoutPage(WebDriver driver) {

		this.driver = driver;

	}

	// Set user name in textbox

	// Click on login button

	public void clickLogout() {

		driver.findElement(logout).click();

	}

	/**
	 * 
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * 
	 * @param strPasword
	 * 
	 * @return
	 * 
	 */

	public void logoutFromDEWA() {

		// Click Logout button

		this.clickLogout();

	}

}