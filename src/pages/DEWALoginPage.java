package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DEWALoginPage {

    WebDriver driver;

    By DEWAuser = By.name("username");
    By DEWApassword = By.name("password");
    By login = By.xpath("//input[@value='Log In']");

    

    public DEWALoginPage(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(DEWAuser).sendKeys(strUserName);;

    }

    

    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(DEWApassword).sendKeys(strPassword);

    }

    

    //Click on login button

    public void clickLogin(){

            driver.findElement(login).click();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToDEWA(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        
     

    }
	
}