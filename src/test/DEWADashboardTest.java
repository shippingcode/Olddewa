package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.DEWADashboardPageFactory;
import PageFactory.DEWALoginPageFactory;
import PageFactory.DEWALogoutPageFactory;

public class DEWADashboardTest {

    WebDriver driver;

    DEWALoginPageFactory objLogin;

    DEWADashboardPageFactory objDashboard;
       
    DEWALogoutPageFactory objLogout;
      

    @BeforeTest

    public void setup(){

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://dewa.hubeleon.ae/");
        driver.manage().window().maximize();

    }

    /**

     * This test go to http://dewa.hubeleon.ae/

     * Verify login page title as DEWA 

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test(priority=0)

    public void test_Dashboard(){

   //Create Login Page object

    objLogin = new DEWALoginPageFactory(driver);

    //login to application

    objLogin.loginToDEWA("test.admin", "Pa55w0rd1");



    objDashboard = new DEWADashboardPageFactory(driver);
   

  //Verify Dashboard

    Assert.assertTrue(objDashboard.getDashboard().contains("DASHBOARD"));
  
    //Logout
    objLogout = new DEWALogoutPageFactory(driver);
    objLogout.logoutFromDEWA();

    }  

}