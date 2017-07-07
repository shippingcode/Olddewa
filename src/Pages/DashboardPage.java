package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;

	By Dashboard = By.id("topmenu_dashboard");

	public DashboardPage(WebDriver driver) {

		this.driver = driver;

	}

	// Get Dashboard elements

	public String getDashboard() {

		return driver.findElement(Dashboard).getText();
	}

}
