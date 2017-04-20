package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class DEWADashboard {

    WebDriver driver;

    By Dashboard = By.id("topmenu_dashboard");

    

    public DEWADashboard(WebDriver driver){

        this.driver = driver;

    }

    

    //Get the User name from Home Page

        public String getDashboard(){

         return    driver.findElement(Dashboard).getText();

        }

}