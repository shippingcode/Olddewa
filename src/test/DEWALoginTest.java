package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DEWADashboardPage;
import pages.DEWALoginPage;

public class DEWALoginTest {

    WebDriver driver;

    DEWALoginPage objLogin;

    DEWADashboardPage objDashboard;
      

    @BeforeTest

    public void setup(){

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://dewa.hubeleon.ae/");

    }

    /**

     * This test case will login in http://dewa.hubeleon.ae/

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test(priority=0)

    public void test_Dashboard(){

        //Create Login Page object

    objLogin = new DEWALoginPage(driver);

     //login to application

    objLogin.loginToDEWA("test.admin","Pa55w0rd1");

    // go the next page

    objDashboard = new DEWADashboardPage(driver);

    //Verify Dashboard

    Assert.assertTrue(objDashboard.getDashboard().contains("DASHBOARD"));
  

    }
}