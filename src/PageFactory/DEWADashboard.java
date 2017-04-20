package PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class DEWADashboard {

    WebDriver driver;

    @FindBy(id="topmenu_dashboard")

    WebElement Dashboard;

    

    public DEWADashboard(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

   
    //Get the text from MENU

        public String getDashboard(){

         return    Dashboard.getText();

        }
        

}