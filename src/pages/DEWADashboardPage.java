package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DEWADashboardPage {

    WebDriver driver;

    By Dashboard = By.id("topmenu_dashboard");
  
    

    public DEWADashboardPage(WebDriver driver){

        this.driver = driver;

    }

    

    //Get Dashboard elements

        public String getDashboard(){

        return driver.findElement(Dashboard).getText();
        }
      
        }

