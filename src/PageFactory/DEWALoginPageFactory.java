package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DEWALoginPageFactory {

    /**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;

    @FindBy(name="username")

    WebElement DEWAuser;

    

    @FindBy(name="password")

    WebElement DEWApassword;

      

    @FindBy(xpath="//input[@value='Log In']")

    WebElement login;

    

    public DEWALoginPageFactory(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        DEWAuser.sendKeys(strUserName);
       

    }
  

    //Set password in password textbox

    public void setPassword(String strPassword){

    DEWApassword.sendKeys(strPassword);

    }

   
    //Click on login button

    public void clickLogin(){

            login.click();

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